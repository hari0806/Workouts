package com.sample.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by HARI on 12/22/2015.
 */
public class LambdaSamples {


    public static void main(String[] args) {
        LambdaSamples lambdaSamples = new LambdaSamples();
        lambdaSamples.copyObject();
    }

    private void copyObject() {
        List<Domain> listDomain = new ArrayList<Domain>();
        Domain dom = new Domain();
        dom.setIdentifier("1");
        dom.setDescription("First");
        listDomain.add(dom);

        dom = new Domain();
        dom.setIdentifier("2");
        dom.setDescription("Second");
        listDomain.add(dom);

        List<View> listView = new ArrayList<View>(listDomain.size());

        //listView.forEach(v -> v.setId(((Domain)listDomain.get(0)).getIdentifier()));
        listDomain.forEach(d -> {
            View view = new View();
            view.setId(d.getIdentifier());
            view.setDesc(d.getDescription());
              listView.add(view);
        });

        listView.forEach(v -> System.out.println(v.getDesc()));

        System.out.println("List view size: " + listView.size());

        View view = new View();
        view.setId("Nothing");
        view.setDesc("Nothing");

        listView.replaceAll(v -> {v.setId("Nothing"); v.setDesc("NothingDesc"); return v;});
        listView.forEach(v -> System.out.println(v.getDesc()));

//        Collections.copy(listDomain,listView);
        System.out.println("finished");

    }

    private class Domain {

        private String identifier;

        private String description;

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


    private class View{

        private String id;

        private String desc;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
