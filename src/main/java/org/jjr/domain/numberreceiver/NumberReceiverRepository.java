package org.jjr.domain.numberreceiver;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberReceiverRepository extends MongoRepository<Ticket, String> {
}
