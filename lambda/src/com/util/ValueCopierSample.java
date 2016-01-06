package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Sample class to use the value copier
 */
public class ValueCopierSample {

    //Main method
    public static void main(String[] args) {
        ValueCopierSample valueCopierTest = new ValueCopierSample();
        valueCopierTest.copyObjectValues();
    }

    /**
     * Method to copy values from one object/list to another.
     */
    private void copyObjectValues() {

        List<Domain> domainList = createDomainList();

        //Creating mapper
        Function<Domain, View> mapper
                = d -> {
            View v = new View();
            v.setDesc(d.getDescription());
            v.setId(d.getIdentifier());
            return v;
        };

        //Creating list mapper object
        ValueCopier<Domain, View> valueCopier = new ValueCopier<>();

        //Copy the values from source object list to destination object list
        View view = valueCopier.copyValuesFromObject(domainList.get(0), mapper);

        //Copy the values from source object list to destination object list
        List<View> viewList = valueCopier.copyValuesFromObjectList(domainList, mapper);


        //Printing the values of view list and view object
        System.out.println("View object:");
        System.out.println(view.toString());
        System.out.println("--------------------");
        System.out.println("View List:");
        viewList.forEach(v -> System.out.println(v.toString()));


    }

    /**
     * To create list of domains with filled values
     *
     * @return listDomain
     */
    private List<Domain> createDomainList() {
        List<Domain> listDomain = new ArrayList<>();
        Domain dom = new Domain();
        dom.setIdentifier("001");
        dom.setDescription("FirstObject");
        listDomain.add(dom);

        dom = new Domain();
        dom.setIdentifier("002");
        dom.setDescription("SecondObject");
        listDomain.add(dom);
        return listDomain;
    }

    /**
     * Domain class
     */
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

    /**
     * View class
     */
    private class View {

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

        @Override
        public String toString() {
            return "[".concat("ID: ").concat(id)
                    .concat(" | Desc: ").concat(desc)
                    .concat("]");
        }
    }
}
