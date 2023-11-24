package com.mikko.mmback.repos;

import com.mikko.mmback.entities.Campaigns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaigns, Integer> {
}
