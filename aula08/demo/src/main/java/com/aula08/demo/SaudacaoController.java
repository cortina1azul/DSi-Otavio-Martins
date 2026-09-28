package com.aula08.demo;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController {

    private static final String MODELO = "Furry Femboy No Aura, %s!";
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final AtomicLong sequencia = new AtomicLong();
    private final List<Saudacao> registro = new CopyOnWriteArrayList<>();

    private static String dataAtual() {
        return ZonedDateTime.now(FUSO).withDayOfMonth(27).format(FORMATO_DATA);
    }

    private Saudacao registrar(String nome) {
        Saudacao saudacao = new Saudacao(sequencia.incrementAndGet(), String.format(MODELO, nome), dataAtual());
        registro.add(saudacao);
        return saudacao;
    }

    @GetMapping("/APIteste")
    public Saudacao gerar(@RequestParam(value = "nome", defaultValue = "visitante") String nome) {
        return registrar(nome);
    }

    @PostMapping("/APIteste")
    public ResponseEntity<?> criar(@RequestBody SaudacaoRequest corpo) {
        if (corpo == null || corpo.nome() == null || corpo.nome().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "o campo 'nome' é obrigatório"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(registrar(corpo.nome().trim()));
    }

    @GetMapping("/APIteste/historico")
    public List<Saudacao> listar() {
        return registro;
    }

    @GetMapping("/APIteste/{id}")
    public ResponseEntity<Saudacao> buscar(@PathVariable long id) {
        return registro.stream()
                .filter(s -> s.id() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/APIteste/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id) {
        boolean removida = registro.removeIf(s -> s.id() == id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return Map.of("status", "ok", "hora", dataAtual(), "total", registro.size());
    }
}
