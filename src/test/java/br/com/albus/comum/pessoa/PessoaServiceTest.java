package br.com.albus.comum.pessoa;

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
@DatabaseSetup(value = PessoaServiceTest.DATASET, type = DatabaseOperation.INSERT)
public class PessoaServiceTest extends GenericTest {

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
        mockMvc.perform(get("/albus/pessoa/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nome", is("Leonardo Balan")))
                .andExpect(jsonPath("$.apelido", is("Leo Balan")));
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].nome", is("Eduardo Balan")))
                .andExpect(jsonPath("$.[0].apelido", is("Edu Balan")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].nome", is("Leonardo Balan")))
                .andExpect(jsonPath("$.[1].apelido", is("Leo Balan")))
                .andExpect(jsonPath("$.[3].id", is(4)))
                .andExpect(jsonPath("$.[3].nome", is("Higor")))
                .andExpect(jsonPath("$.[3].apelido", is("Higor Delas")));
    }

    @Test
    public void inserirTest() throws Exception {
        Pessoa dbPessoa = new Pessoa();
        dbPessoa.setNome("Higor");
        dbPessoa.setApelido("Higor Delas");

        mockMvc.perform(post("/albus/pessoa")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dbPessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",notNullValue()))
                .andExpect(jsonPath("$.nome", is("Higor")))
                .andExpect(jsonPath("$.apelido", is("Higor Delas")));
    }

    @Test
    public void editarTest() throws Exception {

        ResultActions resultadoConsulta = mockMvc.perform(get("/albus/pessoa/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nome", is("Leonardo Balan")))
                .andExpect(jsonPath("$.apelido", is("Leo Balan")));

        Pessoa pessoa = new ObjectMapper().readValue(resultadoConsulta.andReturn().getResponse().getContentAsString(), Pessoa.class);
        pessoa.setNome("Nome editado");
        pessoa.setApelido("Apelido editado");


        mockMvc.perform(put("/albus/pessoa/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(pessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nome", is("Nome editado")))
                .andExpect(jsonPath("$.apelido", is("Apelido editado")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(get("/albus/pessoa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)));

        mockMvc.perform(delete("/albus/pessoa/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/albus/pessoa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }
}