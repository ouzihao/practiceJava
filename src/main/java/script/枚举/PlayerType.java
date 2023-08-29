package script.枚举;

import java.util.EnumMap;
import java.util.EnumSet;

public enum PlayerType {

    TENNIS("网球"),
    FOOTBALL("足球"),
    BASKETBALl("篮球");

    private String name;

    PlayerType(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        EnumSet<PlayerType> enumSet = EnumSet.allOf(PlayerType.class);
        System.out.println(enumSet);

        EnumMap<PlayerType, String> enumMap = new EnumMap<PlayerType, String>(PlayerType.class);
        System.out.println(enumMap);

        enumMap.put(PlayerType.BASKETBALl,"篮球运动员");
        enumMap.put(PlayerType.FOOTBALL,"足球运动员");
        enumMap.put(PlayerType.TENNIS,"网球运动员");
        System.out.println(enumMap);

        System.out.println(enumMap.containsKey(PlayerType.BASKETBALl));
        System.out.println(enumMap.remove(PlayerType.BASKETBALl));
        System.out.println(enumMap.get(PlayerType.FOOTBALL));
    }

}
