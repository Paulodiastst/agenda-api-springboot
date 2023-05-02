package br.com.futurodev.agenda.controllers;

import br.com.futurodev.agenda.model.Contato;
import br.com.futurodev.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Contato> cadastrar(@RequestBody Contato contato) {
        Contato cont = contatoRepository.save(contato);
        return new ResponseEntity<Contato>(cont, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Contato> atualizar(@RequestBody Contato contato) {
        Contato cont = contatoRepository.save(contato);
        return new ResponseEntity<Contato>(cont, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long id) {
        contatoRepository.deleteById(id);
        return new ResponseEntity<String>("Contato deletado com sucesso.", HttpStatus.OK);
    }

    @GetMapping(value = "/{idContato}")
    public ResponseEntity<Contato> getContatoById(@PathVariable(value = "idContato") Long idContato){
        Contato cont = contatoRepository.findById(idContato).get();
        return new ResponseEntity<Contato>(cont, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public  ResponseEntity<List<Contato>> getCotatoById(@RequestParam (name = "nome") String nome){
        List<Contato> contatos = contatoRepository.getContatoByName(nome);
        return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
    }

}








