package dev.canm.auditing.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AbstractAuditListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditEventListener extends AbstractAuditListener {

    @Autowired
    private PersistedAuditEventRepository auditEventRepository;

    @Override
    protected void onAuditEvent(AuditEvent event) {
        auditEventRepository.add(event);
    }

}
