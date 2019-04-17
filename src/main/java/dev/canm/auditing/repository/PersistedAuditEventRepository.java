package dev.canm.auditing.repository;

import dev.canm.auditing.mapper.AuditEventMapper;
import dev.canm.auditing.model.AuditEventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.stereotype.Repository;

/**
 * JPA repository backed AuditEventRepository implementation.
 */
@Slf4j
@Repository
public class PersistedAuditEventRepository {

    @Autowired
    private AuditEventJpaRepository repository;

    @Autowired
    private AuditEventMapper mapper;

    /**
     * Store an audit event.
     * @param event audit event
     */
    final void add(final AuditEvent event) {
        AuditEventModel auditEventModel = mapper.map(event, AuditEventModel.class);
        repository.save(auditEventModel);
    }

}
