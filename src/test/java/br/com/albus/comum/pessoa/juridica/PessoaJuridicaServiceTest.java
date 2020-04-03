package br.com.albus.comum.pessoa.juridica;

import br.com.albus.AlbusAppTest;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = AlbusAppTest.class)
@DatabaseSetup(value = PessoaJuridicaServiceTest.DATASET, type = DatabaseOperation.INSERT)
public class PessoaJuridicaServiceTest extends GenericTest {

    protected static final String DATASET = "classpath:datasets/comum/pessoa/pessoa-service-test.xml";

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa/juridica/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.nome", is("AZ LIMIT")))
                .andExpect(jsonPath("$.apelido", is("AZ")))
                .andExpect(jsonPath("$.cnpj", is("55")));
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa/juridica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(5)))
                .andExpect(jsonPath("$.[0].nome", is("AZ LIMIT")))
                .andExpect(jsonPath("$.[0].apelido", is("AZ")))
                .andExpect(jsonPath("$.[0].cnpj", is("55")))
                .andExpect(jsonPath("$.[1].id", is(6)))
                .andExpect(jsonPath("$.[1].nome", is("IT LIMIT")))
                .andExpect(jsonPath("$.[1].apelido", is("Inteco")))
                .andExpect(jsonPath("$.[1].cnpj", is("66")));
    }

    @Test
    public void inserirTest() throws Exception {
        PessoaJuridica dbPessoa = new PessoaJuridica();
        dbPessoa.setNome("Higor");
        dbPessoa.setApelido("Higor Delas");
        dbPessoa.setCnpj("77");

        mockMvc.perform(post("/albus/pessoa/juridica")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dbPessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.nome", is("Higor")))
                .andExpect(jsonPath("$.apelido", is("Higor Delas")))
                .andExpect(jsonPath("$.cnpj", is("77")));
    }

    @Test
    public void editarTest() throws Exception {

        ResultActions resultadoConsulta = mockMvc.perform(get("/albus/pessoa/juridica/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.nome", is("AZ LIMIT")))
                .andExpect(jsonPath("$.apelido", is("AZ")))
                .andExpect(jsonPath("$.cnpj", is("55")));

        PessoaJuridica pessoa = new ObjectMapper().readValue(resultadoConsulta.andReturn().getResponse().getContentAsString(), PessoaJuridica.class);
        pessoa.setNome("Nome editado");
        pessoa.setApelido("Apelido editado");
        pessoa.setCnpj("555");


        mockMvc.perform(put("/albus/pessoa/juridica/5")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(pessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.nome", is("Nome editado")))
                .andExpect(jsonPath("$.apelido", is("Apelido editado")))
                .andExpect(jsonPath("$.cnpj", is("555")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa/juridica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        mockMvc.perform(delete("/albus/pessoa/juridica/5"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/albus/pessoa/juridica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}