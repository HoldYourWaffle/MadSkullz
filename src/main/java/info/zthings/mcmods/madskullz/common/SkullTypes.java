package info.zthings.mcmods.madskullz.common;

import net.minecraft.util.IStringSerializable;

public enum SkullTypes implements IStringSerializable {
    WHITE(0, "white"),
    BLACK(1, "black");

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