package org.shell.mmo.sample.catan;

import org.shell.mmo.sample.message.proto.Global;

import java.util.*;

/**
 * Created by zhangxiangxi on 16/8/1.
 */
public class Catan {
    final CatanMap map;
    final List<Long> initList; // 需要初始化的玩家
    final List<Long> commonList;
    final Map<Long, CatanRole> roles;
    int pos = 0;
    CatanRound round;
    int dice;
    CatanRole roadKing;
    CatanRole knightKing;
    final List<Global.CatanCardType> cards;
    final int[] resource;
    final int winScore = 10;

    public Catan(CatanMap map, List<Long> initList, Map<Long, CatanRole> roles, List<Global.CatanCardType> cards, int[] resource) {
        this.map = map;
        this.initList = initList;
        this.roles = roles;
        this.commonList = new ArrayList<>(initList.subList(0, initList.size() / 2));
        this.cards = cards;
        this.resource = resource;
    }

    public CatanMap getMap() {
        return map;
    }

    public List<Long> getInitList() {
        return initList;
    }

    public List<Long> getCommonList() {
        return commonList;
    }

    public Map<Long, CatanRole> getRoles() {
        return roles;
    }

    public int getPos() {
        return pos;
    }

    public CatanRound getRound() {
        return round;
    }

    public int getDice() {
        return dice;
    }

    public void addResource(Global.CatanResourceType type, int count) {
        resource[type.ordinal()] += count;
    }

    public void subResource(Global.CatanResourceType type, int count) {
        resource[type.ordinal()] -= count;
    }

    public int getResource(Global.CatanResourceType type) {
        return resource[type.ordinal()];
    }

    public static class CatanRole {
        public final static int ROAD_MAX = 15;
        public final static int COUNTRY_MAX = 5;
        public final static int CITY_MAX = 4;
        final long id;
        final Set<CatanMap.CatanPoint> countries = new HashSet<>();
        final Set<CatanMap.CatanPoint> cities = new HashSet<>();
        final Set<CatanMap.CatanEdge> edges = new HashSet<>();
        final Set<Global.CatanPortType> ports = new HashSet<>();
        final int[] resource = new int[Global.CatanResourceType.values().length];
        final int[] card = new int[Global.CatanCardType.values().length];
        int knight;
        int road;
        int point;
        int score;

        public int[] getResource() {
            return resource;
        }

        public CatanRole(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public Set<CatanMap.CatanPoint> getCountries() {
            return countries;
        }

        public Set<CatanMap.CatanPoint> getCities() {
            return cities;
        }

        public Set<CatanMap.CatanEdge> getEdges() {
            return edges;
        }

        public int getResource(Global.CatanResourceType type) {
            return resource[type.ordinal()];
        }

        public void subResource(Global.CatanResourceType type, int count) {
            resource[type.ordinal()] -= count;
        }

        public int getCard(Global.CatanCardType type) {
            return card[type.ordinal()];
        }

        public void addResource(Global.CatanResourceType type, int count) {
            resource[type.ordinal()] += count;
        }

        public void subCard(Global.CatanCardType type, int count) {
            card[type.ordinal()] -= count;
        }

        public void addCard(Global.CatanCardType type, int count) {
            if (type == Global.CatanCardType.CARD_POINT) {
                ++point;
                return;
            }
            card[type.ordinal()] -= count;
        }
    }
}
