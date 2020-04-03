package br.com.albus.comum.pessoa.fisica;

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
@DatabaseSetup(value = PessoaFisicaServiceTest.DATASET, type = DatabaseOperation.INSERT)
public class PessoaFisicaServiceTest extends GenericTest {

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
        mockMvc.perform(get("/albus/pessoa/fisica/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.nome", is("Higor")))
                .andExpect(jsonPath("$.apelido", is("Higor Delas")))
                .andExpect(jsonPath("$.cpf", is("44")))
                .andExpect(jsonPath("$.rg", is("4444")));
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa/fisica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(3)))
                .andExpect(jsonPath("$.[0].nome", is("Gustavo Balan")))
                .andExpect(jsonPath("$.[0].apelido", is("Gus Balan")))
                .andExpect(jsonPath("$.[0].cpf", is("33")))
                .andExpect(jsonPath("$.[0].rg", is("3333")))
                .andExpect(jsonPath("$.[1].id", is(4)))
                .andExpect(jsonPath("$.[1].nome", is("Higor")))
                .andExpect(jsonPath("$.[1].apelido", is("Higor Delas")))
                .andExpect(jsonPath("$.[1].cpf", is("44")))
                .andExpect(jsonPath("$.[1].rg", is("4444")));
    }

    @Test
    public void inserirTest() throws Exception {
        PessoaFisica dbPessoa = new PessoaFisica();
        dbPessoa.setNome("Higor");
        dbPessoa.setApelido("Higor Delas");
        dbPessoa.setCpf("77");
        dbPessoa.setRg("7777");

        mockMvc.perform(post("/albus/pessoa/fisica")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dbPessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.nome", is("Higor")))
                .andExpect(jsonPath("$.apelido", is("Higor Delas")))
                .andExpect(jsonPath("$.cpf", is("77")))
                .andExpect(jsonPath("$.rg", is("7777")));
    }

    @Test
    public void editarTest() throws Exception {

        ResultActions resultadoConsulta = mockMvc.perform(get("/albus/pessoa/fisica/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.nome", is("Gustavo Balan")))
                .andExpect(jsonPath("$.apelido", is("Gus Balan")));

        PessoaFisica pessoa = new ObjectMapper().readValue(resultadoConsulta.andReturn().getResponse().getContentAsString(), PessoaFisica.class);
        pessoa.setNome("Nome editado");
        pessoa.setApelido("Apelido editado");
        pessoa.setCpf("alterado");
        pessoa.setRg("alterado2");


        mockMvc.perform(put("/albus/pessoa/fisica/3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(pessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.nome", is("Nome editado")))
                .andExpect(jsonPath("$.apelido", is("Apelido editado")))
                .andExpect(jsonPath("$.cpf", is("alterado")))
                .andExpect(jsonPath("$.rg", is("alterado2")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa/fisica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        mockMvc.perform(delete("/albus/pessoa/fisica/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/albus/pessoa/fisica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}