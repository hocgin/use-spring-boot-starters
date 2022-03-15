package in.hocg.javers.controller;

import in.hocg.javers.domain.Account;
import in.hocg.javers.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;
    private final Javers javers;

    @PostMapping("/{id}/create")
    public void create(@PathVariable final Long id) {
        service.create(id);
    }

    @PostMapping("/{id}/rename/{rename}")
    public void rename(@PathVariable final Long id, @PathVariable String rename) {
        service.rename(id, rename);
    }

    @PostMapping(value = "/{id}/setting")
    public void updateSetting(@PathVariable final Long id, @RequestBody String setting) {
        service.updateSetting(id, setting);
    }

    @GetMapping("/{id}/changes")
    public String getChanges(@PathVariable Long id) {
        Account account = service.findById(id);
        QueryBuilder jqlQuery = QueryBuilder.byInstance(account);
        Changes changes = javers.findChanges(jqlQuery.build());
        return javers.getJsonConverter().toJson(changes);
    }

    @GetMapping("/{id}/shadows")
    public String getShadows(@PathVariable Long id) {
        Account account = service.findById(id);
        JqlQuery jqlQuery = QueryBuilder.byInstance(account)
                .withChildValueObjects().build();
        List<Shadow<Account>> shadows = javers.findShadows(jqlQuery);
        return javers.getJsonConverter().toJson(shadows.get(0));
    }

    @GetMapping("/snapshots")
    public String getStoresSnapshots() {
        QueryBuilder jqlQuery = QueryBuilder.byClass(Account.class);
        List<CdoSnapshot> snapshots = javers.findSnapshots(jqlQuery.build());
        return javers.getJsonConverter().toJson(snapshots);
    }

}
