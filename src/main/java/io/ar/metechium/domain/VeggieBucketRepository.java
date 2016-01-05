package io.ar.metechium.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeggieBucketRepository extends CrudRepository<VeggieBucket, Long> {

}
