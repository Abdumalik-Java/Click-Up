package abdumalik.dev.clickup.controller;

import abdumalik.dev.clickup.dto.ClickAppsDto;
import abdumalik.dev.clickup.model.ClickApps;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.service.ClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clickApps")
public class ClickAppsController {

    @Autowired
    ClickAppsService clickAppsService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<ClickApps> clickApps = clickAppsService.getClickApps();
        return new ResponseEntity<>(clickApps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        ClickApps clickApps = clickAppsService.getClickApps(id);
        return new ResponseEntity<>(clickApps, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable String name) {
        ClickApps clickAppsByName = clickAppsService.getClickAppsByName(name);
        return new ResponseEntity<>(clickAppsByName, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody ClickAppsDto clickAppsDto) {
        Result result = clickAppsService.create(clickAppsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody ClickAppsDto clickAppsDto) {
        Result result = clickAppsService.update(clickAppsDto, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result result = clickAppsService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}