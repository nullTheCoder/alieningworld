package aw.generation.materials;

import aw.AlieningWorld;
import aw.generation.Generator;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Elements {
    private static Elements instance;
    public static Elements getInstance() {
        return instance;
    }
    // ---------------------- ---------------------- ---------------------- ---------------------- ---------------------- \\


    private Map<String, Map<String, WInteract>> WParticles;
    private List<Element> elements;

    public Elements() {
        instance = this;

        WParticles = new HashMap<>();

        String str = "qwertyuiopasdfghjklzxcvbnm1234567890";
        int stabilityColor[]=new int[3];
        int instabilityColor[]=new int[3];

        for (int i = 0; i < AlieningWorld.amountOfWParticles; i++) {
            Map<String, WInteract> interactMap = new HashMap<>();
            int i1 = 0;
            int rv = Generator.getNextRandomNum();
            for (String x : WParticles.keySet()) {
                if (Math.sin(i1*5+i*5+(rv))<-0.4) {
                    double v = Math.sin(i1 * i * (rv / 25));
                    if (v <0) {
                        interactMap.put(x, WInteract.STABILIZE);
                    } else if (v <0.6){
                        interactMap.put(x, WInteract.DESTROY);
                    } else {
                        interactMap.put(x, WInteract.BOTH_DESTROY);
                    }
                }
                i1++;
            }
            System.out.println("Created WParticle: " + str.charAt(i) + ", which interacts with: " + interactMap);
            WParticles.put(""+str.charAt(i), interactMap);
        }

        System.out.println("Created WParticles");

        elements = new ArrayList<>();

        for (int i = 0; i < AlieningWorld.amountOfElements; i++) {
            Element element = new Element();
            int r=0,g=0,b=0;
            Map<String, EInteract> interactMap = new HashMap<>();

            int stability = 0;
            String currentLayer = "";

            int rv = Generator.getNextRandomNum();
            for (int i1=0; i1<AlieningWorld.elementBulkiness; i1++) {
                int i2 = 0;
                for (Map.Entry<String, Map<String, WInteract>> x : WParticles.entrySet()) {
                    if (Math.sin(i1*5+i*5+(rv))<-0.4) {
                        main : for (Map.Entry<String, WInteract> y : x.getValue().entrySet()) {
                            if (y.getValue() == WInteract.DESTROY) {
                                for (char c : currentLayer.toCharArray()) {
                                    if (c==y.getKey().charAt(0)) {
                                        stability-=1;
                                        if (stability<0) {
                                            continue main;
                                        }
                                    }
                                }
                                r += instabilityColor[0] / 4;
                                g += instabilityColor[1] / 4;
                                b += instabilityColor[2] / 4;
                            } else if (y.getValue() == WInteract.STABILIZE) {
                                for (char c : currentLayer.toCharArray()) {
                                    if (c==y.getKey().charAt(0)) {
                                        stability+=2;
                                        if (stability<0) {
                                            continue main;
                                        }
                                    }
                                }
                                r += stabilityColor[0] / 4;
                                g += stabilityColor[1] / 4;
                                b += stabilityColor[2] / 4;
                            } else {
                                for (char c : currentLayer.toCharArray()) {
                                    if (c==y.getKey().charAt(0)) {
                                        stability-=1;
                                        if (stability<0) {
                                            continue main;
                                        }
                                    }
                                }
                                r += instabilityColor[0] / 2;
                                g += instabilityColor[1] / 2;
                                b += instabilityColor[2] / 2;
                            }
                            currentLayer += y.getKey();
                        }
                    }
                    i2++;
                }
            }
            System.out.println(currentLayer);

            elements.add(element);
        }


    }

}
