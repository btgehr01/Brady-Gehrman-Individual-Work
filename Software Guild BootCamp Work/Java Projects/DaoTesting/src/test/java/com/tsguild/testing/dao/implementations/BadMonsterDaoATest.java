/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.testing.dao.implementations;

import com.tsguild.testing.dao.MonsterDao;
import com.tsguild.testing.model.Monster;
import static com.tsguild.testing.model.MonsterType.WEREWOLF;
import static com.tsguild.testing.model.MonsterType.YETI;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class BadMonsterDaoATest {

    public BadMonsterDaoATest() {
    }

    MonsterDao dao;

    @Before
    public void setUp() {
        dao = new BadMonsterDaoA();
    }

    @Test
    public void AddGetMonsterMethodTest() {
        int id = 0001;
        Monster bob = new Monster("Bob", YETI, 2, "tacos");
        dao.addMonster(id, bob);
        Monster addedMonster = dao.getMonster(0001);
        Assert.assertNotNull("testng to see if the added monster is not null in memory", addedMonster);
        Assert.assertEquals("testing to see if the monster name is correct", bob.getName(), addedMonster.getName());
        Assert.assertEquals("testing to see if the monster type is correct", bob.getType(), addedMonster.getType());
        Assert.assertEquals("testing to see if the monster humans killed is correct", bob.getPeopleEaten(), addedMonster.getPeopleEaten());
        Assert.assertEquals("testing to see if the monster's favorite food is correct", bob.getFavoriteFood(), addedMonster.getFavoriteFood());

    }

    @Test
    public void GetAllMonsterMethodTest() {
        int idBob = 0001;
        Monster bob = new Monster("Bob", YETI, 2, "tacos");
        int idJeff = 0002;
        Monster jeff = new Monster("Jeff", WEREWOLF, 5, "bones");

        dao.addMonster(idBob, bob);
        dao.addMonster(idJeff, jeff);

        List<Monster> monsterList = dao.getAllMonsters();

        Assert.assertNotNull("checking to make sure the list of monsters is not null", monsterList);
        Assert.assertEquals("testing to my sure thst monster list only has 2 new objects inside of it", 2, monsterList.size());

        Assert.assertTrue("testing to see if monsterList has bob inside of it", monsterList.contains(bob));
        Assert.assertTrue("testing to see if monsterList has jeff inside of it", monsterList.contains(jeff));
    }

    @Test
    public void updateMonsterMethodTest() {
        //create two monsters
        int idBob = 0001;
        Monster bob = new Monster("Bob", YETI, 2, "tacos");
        int idJeff = 0002;
        Monster jeff = new Monster("Jeff", WEREWOLF, 5, "bones");

        //add the monsters to memory
        dao.addMonster(idBob, bob);
        dao.addMonster(idJeff, jeff);

        //create two updated monsters
        Monster newBob = new Monster("Bob", YETI, 5, "Chicken Tacos");
        Monster newJeff = new Monster("Jeff", WEREWOLF, 10, "bones");

        //update the monsters in the dao memory
        dao.updateMonster(idBob, newBob);
        dao.updateMonster(idJeff, newJeff);

        //get the monsters out of the dao again
        Monster retrivedNewBob = dao.getMonster(idBob);
        Monster retrivedNewJeff = dao.getMonster(idJeff);

        //make sure bob was changed
        Assert.assertEquals("checking to make sure that the updated Bob's name has remained unchanged", bob.getName(), retrivedNewBob.getName());
        Assert.assertEquals("checking to make sure that the updated Bob's monsterType has remained unchanged", bob.getType(), retrivedNewBob.getType());
        Assert.assertNotSame("checking to make sure that the updated Bob's humansEaten stat was changed", bob.getPeopleEaten(), retrivedNewBob.getPeopleEaten());
        Assert.assertNotSame("checking to make sure that the updated Bob's favoriteFood stat was changed", bob.getFavoriteFood(), retrivedNewBob.getFavoriteFood());

        //make sure jeff was changed
        Assert.assertEquals("checking to make sure that the updated Jeff's name remained unchanged", jeff.getName(), retrivedNewJeff.getName());
        Assert.assertEquals("checking to make sure that the updated Jeff's monsterType remained unchanged", jeff.getType(), retrivedNewJeff.getType());
        Assert.assertNotSame("checking to make sure that the updated Jeff's humansEaten stat was changed", jeff.getPeopleEaten(), retrivedNewJeff.getPeopleEaten());
        Assert.assertEquals("checking to make sure that the updated Jeffs's favorite food has remained unchanged", jeff.getType(), retrivedNewJeff.getType());
    }

    @Test
    public void RemoveMonsterMethodTest() {
        int idBob = 0001;
        Monster bob = new Monster("Bob", YETI, 2, "tacos");
        int idJeff = 0002;
        Monster jeff = new Monster("Jeff", WEREWOLF, 5, "bones");

        dao.addMonster(idBob, bob);
        dao.addMonster(idJeff, jeff);

        Monster removedBob = dao.removeMonster(idBob);

        Assert.assertEquals("making sure that bob was the removed monster", bob, removedBob);

        List<Monster> monsterList = dao.getAllMonsters();

        Assert.assertNotNull("making sure the list of monsters isn't null", monsterList);
        Assert.assertEquals("making sure that the monsterList only still has one monster in it", 1, monsterList.size());
        Assert.assertFalse("making sure bob is not inside of the list", monsterList.contains(bob));
        Assert.assertTrue("making sure that the list contains jeff", monsterList.contains(jeff));

        Monster hopefullyNullBob = dao.getMonster(idBob);

        Assert.assertNull("testing to make sure that bob is not still in memory", hopefullyNullBob);
        //remove the other monster

        Monster removedJeff = dao.removeMonster(idJeff);

        Assert.assertEquals("making sure jeff was the removed monster", jeff, removedJeff);

        monsterList = dao.getAllMonsters();

        Assert.assertTrue("making sure that the monster list is now empty", monsterList.isEmpty());

        Monster hopefullyNullJeff = dao.getMonster(idJeff);
        hopefullyNullBob = dao.getMonster(idBob);

        Assert.assertNull("making sure jeff is now null", hopefullyNullJeff);
        Assert.assertNull("making sure bob is still null", hopefullyNullBob);

    }
}
