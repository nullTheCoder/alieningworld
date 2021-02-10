package aw.generation.materials;

import java.util.Map;

import java.awt.Color;

public class Element {
    public int id;
    public Color color;
    public String[][] structure;
    public int distanceBetwenLayers;
    public Map<Integer, EInteract> interactMap;
}
