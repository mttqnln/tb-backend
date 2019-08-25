package com.lolteambuilder;

import com.lolteambuilder.model.MatchupChamp;
import com.lolteambuilder.model.MatchupResponse;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import static com.lolteambuilder.Keys.RIOT_KEY;

@RestController
public class CoreController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/matchup")
    public MatchupResponse getMatchup() {

        Orianna.setRiotAPIKey(RIOT_KEY);
        Orianna.setDefaultPlatform(Platform.NORTH_AMERICA);

        Champions champions = Orianna.getChampions();

        //Champ 1
        int randomNum1 = ThreadLocalRandom.current().nextInt(0, champions.size() + 1);
        Champion randomChamp1 = champions.get(randomNum1);
        MatchupChamp champ1 = MatchupChamp
                .builder()
                .imageUrl(randomChamp1.getImage().getURL())
                .name(randomChamp1.getName())
                .build();

        //Champ 2
        int randomNum2 = ThreadLocalRandom.current().nextInt(0, champions.size() + 1);
        Champion randomChamp2 = champions.get(randomNum2);
        MatchupChamp champ2 = MatchupChamp
                .builder()
                .imageUrl(randomChamp2.getImage().getURL())
                .name(randomChamp2.getName())
                .build();

        return MatchupResponse
                .builder()
                .champ1(champ1)
                .champ2(champ2)
                .build();
    }
}
