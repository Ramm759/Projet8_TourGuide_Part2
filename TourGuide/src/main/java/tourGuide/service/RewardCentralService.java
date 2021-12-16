package tourGuide.service;

import rewardCentral.RewardCentral;
import tourGuide.proxy.gpsUtil.dto.Attraction;
import tourGuide.user.User;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RewardCentralService {
    private RewardCentral rewardCentral = new RewardCentral();
    // on autorise 10000 Threads
    private ExecutorService executorService = Executors.newFixedThreadPool(10000);

    public CompletableFuture<Integer> getAttractionRewardPoints(Attraction attraction, User user) {

        // getAttractionRewardPoints peut s'executer sur plusieurs threads
        return CompletableFuture.supplyAsync(() -> rewardCentral.getAttractionRewardPoints(attraction.attractionId, user.getUserId()), executorService);
    }

}
