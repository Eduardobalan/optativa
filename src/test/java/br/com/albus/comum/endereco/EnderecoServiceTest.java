package br.com.albus.comum.endereco;

import br.com.albus.AlbusAppTest;
import br.com.albus.comum.municipio.Municipio;
import br.com.albus.config.GenericTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = AlbusAppTest.class)
@DatabaseSetup(value = EnderecoServiceTest.DATASET, type = DatabaseOperation.INSERT)
public class EnderecoServiceTest extends GenericTest {

    protected static final String DATASET = "classpath:datasets/comum/endereco-service-test.xml";

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/albus/endereco/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.municipio", notNullValue()))
                .andExpect(jsonPath("$.municipio.id", is(1)))
                .andExpect(jsonPath("$.municipio.nome", is("Coxim")))
                .andExpect(jsonPath("$.tipoEndereco", is(EnumTipoEndereco.CASA.toString())))
                .andExpect(jsonPath("$.logradouro", is("Endereco 2")))
                .andExpect(jsonPath("$.numero", is("numero 2")))
                .andExpect(jsonPath("$.complemento", is("complemento 2")))
                .andExpect(jsonPath("$.bairro", is("bairro 2")))
                .andExpect(jsonPath("$.referencia", is("referencia 2")));
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/albus/endereco"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].municipio.id", is(1)))
                .andExpect(jsonPath("$.[1].municipio.nome", is("Coxim")))
                .andExpect(jsonPath("$.[1].tipoEndereco", is(EnumTipoEndereco.CASA.toString())))
                .andExpect(jsonPath("$.[1].logradouro", is("Endereco 2")))
                .andExpect(jsonPath("$.[1].numero", is("numero 2")))
                .andExpect(jsonPath("$.[1].complemento", is("complemento 2")))
                .andExpect(jsonPath("$.[1].bairro", is("bairro 2")))
                .andExpect(jsonPath("$.[1].referencia", is("referencia 2")))
                .andExpect(jsonPath("$.[2].id", is(3)))
                .andExpect(jsonPath("$.[2].municipio.id", is(2)))
                .andExpect(jsonPath("$.[2].municipio.nome", is("Rio Verde")))
                .andExpect(jsonPath("$.[3].id", is(4)))
                .andExpect(jsonPath("$.[3].municipio.id", is(2)))
                .andExpect(jsonPath("$.[3].municipio.nome", is("Rio Verde")));
    }

    @Test
    public void inserirTest() throws Exception {
        Municipio dbMunicipio = new Municipio();
        dbMunicipio.setId(1L);
        dbMunicipio.setNome("Coxim");

        Endereco newEndereco = new Endereco();
        newEndereco.setTipoEndereco(EnumTipoEndereco.FAZENDA);
        newEndereco.setLogradouro("endereco");
        newEndereco.setBairro("Bairro");
        newEndereco.setComplemento("complemento");
        newEndereco.setNumero("numero");
        newEndereco.setReferencia("referencia");
        newEndereco.setMunicipio(dbMunicipio);

        mockMvc.perform(post("/albus/endereco")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(newEndereco)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.municipio", notNullValue()))
                .andExpect(jsonPath("$.municipio.id", is(1)))
                .andExpect(jsonPath("$.municipio.nome", is("Coxim")))
                .andExpect(jsonPath("$.tipoEndereco", is(EnumTipoEndereco.FAZENDA.toString())))
                .andExpect(jsonPath("$.logradouro", is("endereco")))
                .andExpect(jsonPath("$.numero", is("numero")))
                .andExpect(jsonPath("$.complemento", is("complemento")))
                .andExpect(jsonPath("$.bairro", is("Bairro")))
                .andExpect(jsonPath("$.referencia", is("referencia")));
    }

    @Test
    public void editarTest() throws Exception {

        Municipio dbMunicipio = new Municipio();
        dbMunicipio.setId(1L);


        ResultActions resultadoConsulta = mockMvc.perform(get("/albus/endereco/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.municipio", notNullValue()))
                .andExpect(jsonPath("$.municipio.id", is(1)))
                .andExpect(jsonPath("$.municipio.nome", is("Coxim")))
                .andExpect(jsonPath("$.tipoEndereco", is(EnumTipoEndereco.CASA.toString())))
                .andExpect(jsonPath("$.logradouro", is("Endereco 2")))
                .andExpect(jsonPath("$.numero", is("numero 2")))
                .andExpect(jsonPath("$.complemento", is("complemento 2")))
                .andExpect(jsonPath("$.bairro", is("bairro 2")))
                .andExpect(jsonPath("$.referencia", is("referencia 2")));

        Endereco endereco = new ObjectMapper().readValue(resultadoConsulta.andReturn().getResponse().getContentAsString(), Endereco.class);
        endereco.setTipoEndereco(EnumTipoEndereco.TRABALHO);
        endereco.setLogradouro("endereco");
        endereco.setBairro("Bairro");
        endereco.setComplemento("complemento");
        endereco.setNumero("numero");
        endereco.setReferencia("referencia");
        endereco.setMunicipio(dbMunicipio);

        mockMvc.perform(put("/albus/endereco/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(endereco)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.municipio", notNullValue()))
                .andExpect(jsonPath("$.municipio.id", is(1)))
                .andExpect(jsonPath("$.municipio.nome", is("Coxim")))
                .andExpect(jsonPath("$.tipoEndereco", is(EnumTipoEndereco.TRABALHO.toString())))
                .andExpect(jsonPath("$.logradouro", is("endereco")))
                .andExpect(jsonPath("$.numero", is("numero")))
                .andExpect(jsonPath("$.complemento", is("complemento")))
                .andExpect(jsonPath("$.bairro", is("Bairro")))
                .andExpect(jsonPath("$.referencia", is("referencia")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(get("/albus/endereco"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));

        mockMvc.perform(delete("/albus/endereco/4"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/albus/endereco"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}