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

        for (int i = 0; i < AlieningWorld.amountOfWParticles; i++) {
            Map<String, WInteract> interactMap = new HashMap<>();
            int i1 = 0;
            int rv = Generator.getNextRandomNum();
            for (String x : WParticles.keySet()) {
                if (Math.sin(i1*5+i*5+(rv))<-0.4) {
                    double v = Math.sin(i1 * i * (rv / 25));
                    if (v <0) {
                        interactMap.put(x, WInteract.Stabilize);
                    } else if (v <0.6){
                        interactMap.put(x, WInteract.Destroy);
                    } else {
                        interactMap.put(x, WInteract.BothDestroy);
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

            elements.add(element);

        }


    }

}
