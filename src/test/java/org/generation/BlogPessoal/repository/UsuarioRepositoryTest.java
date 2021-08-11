package org.generation.BlogPessoal.repository;

import org.generation.BlogPessoal.Repository.UsuarioRepository;
import org.generation.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class UsuarioRepositoryTest {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @BeforeAll
        void start() throws ParseException {

            LocalDate data = LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Usuario usuario = new Usuario(0, "João da Silva", "joao@email.com.br", "13465278", data);
            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
                usuarioRepository.save(usuario);

            usuario = new Usuario(0, "Manuel da Silva", "manuel@email.com.br", "13465278", data);
            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
                usuarioRepository.save(usuario);

            usuario = new Usuario(0, "Frederico da Silva", "frederico@email.com.br", "13465278", data);
            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
                usuarioRepository.save(usuario);

            usuario = new Usuario(0, "Paulo Antunes", "paulo@email.com.br", "13465278", data);
            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
                usuarioRepository.save(usuario);
        }

        @Test
        @DisplayName("💾 Retorna o nome")
        public void findByNomeRetornaNome() throws Exception {

            Usuario usuario = usuarioRepository.findByNome("João da Silva");
            assertTrue(usuario.getNome().equals("João da Silva"));
        }

        @Test
        @DisplayName("💾 Retorna 3 usuarios")
        public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {

            List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
            assertEquals(3, listaDeUsuarios.size());
        }

        @AfterAll
        public void end() {

            usuarioRepository.deleteAll();

        }
    }