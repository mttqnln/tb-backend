package com.lolteambuilder.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MatchupResponse {

    private MatchupChamp champ1;
    private MatchupChamp champ2;
}
