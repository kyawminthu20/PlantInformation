package cs401.plantinformation;

import cs401.plantinformation.Plant;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {


    List<Plant> testplantDB= new List<Plant>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Plant> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Plant plant) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Plant> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Plant> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Plant get(int index) {
            return null;
        }

        @Override
        public Plant set(int index, Plant element) {
            return null;
        }

        @Override
        public void add(int index, Plant element) {

        }

        @Override
        public Plant remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Plant> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Plant> listIterator(int index) {
            return null;
        }

        @Override
        public List<Plant> subList(int fromIndex, int toIndex) {
            return null;
        }
    };



    public void settestplantDB(List<Plant> testplantDB) throws IOException {
        this.testplantDB = testplantDB;

        BufferedReader br = new BufferedReader(new FileReader("src/test/java/cs401/plantinformation/testPlantDB.csv"));

        String currentLine = null;

        while ((currentLine = br.readLine()) != null){
            Plant temp = new Plant();

            String[] detailed = currentLine.split(",");
            temp.setCommonName(detailed[0]);
            temp.setScientificName(detailed[1]);
            temp.setTypeOfPlant(Boolean.parseBoolean(detailed[2]));
            temp.setMinGrowingZone(Integer.parseInt(detailed[3]));
            temp.setMaxGrowingZone(Integer.parseInt(detailed[4]));

            testplantDB.add(temp);

        }

    }

    @Test
    void displayMainMenu() {

    }

    @Test
    void addPlantInformation() throws IOException {
        settestplantDB(testplantDB);



    }




}