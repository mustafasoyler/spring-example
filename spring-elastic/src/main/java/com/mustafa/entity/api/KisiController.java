package com.mustafa.entity.api;

import com.mustafa.entity.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.KisiRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {
    private final KisiRepository kisiRepository;

    public KisiController(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

    @PostConstruct
    public void init(){
        Kisi kisi =new Kisi();
        kisi.setAd("mustafa");
        kisi.setSoyad("söyler");
        kisi.setAdres("aaa");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("kkkk00001");
        kisiRepository.save(kisi);

    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKişi(@PathVariable String search){
          List<Kisi> kişiler = kisiRepository.getByCustomQuery(search);
          return ResponseEntity.ok(kişiler);
    }
}
