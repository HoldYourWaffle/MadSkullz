package info.zthings.mcmods.madskullz.common;

import net.minecraft.util.IStringSerializable;

public enum SkullTypes implements IStringSerializable {
    MOB(0, "MOB"),
    PLAYER(1, "PLAYER");

    private int ID;
    private String name;
    
    private SkullTypes(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
    
    @Override
    public String toString() {
    	return getName();
    }
}