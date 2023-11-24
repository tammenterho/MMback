package com.mikko.mmback.services;

import com.mikko.mmback.entities.Campaigns;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final List<Campaigns> campaigns;


    public CampaignService(List<Campaigns> campaigns) {
        this.campaigns = campaigns;
    }

    public Campaigns updateCampaign(int id, Campaigns updatedCampaign) {
        for (int i = 0; i < campaigns.size(); i++) {
            if (campaigns.get(i).getId() == id) {
                campaigns.set(i, updatedCampaign);
                return updatedCampaign;
            }
        }
        return null;
    }
}
