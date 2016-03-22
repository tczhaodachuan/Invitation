package com.zdc.zl.repository.impl;

import com.zdc.zl.model.Guest;
import com.zdc.zl.repository.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by dachuan on 3/22/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "classpath:/app-config.xml"
@ContextConfiguration("/invitation-server-servlet.xml")
public class GuestRepoFileImplTest {

    @Autowired
    private GuestRepository guestRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testReserveGuest() throws Exception {
        Guest dachuan = new Guest();
        dachuan.setEmail("tczhaodachuan@gmail.com");
        dachuan.setMessage("你好，世界！");
        dachuan.setName("赵大川");
        dachuan.setNumber_of_guests(5);
        dachuan.setPhone("2019686045");
        assertTrue(guestRepository.reserveGuest(dachuan));
        Guest zhuli = new Guest();
        zhuli.setEmail("tczhaodachuan@gmail.com");
        zhuli.setMessage("你好，世界！");
        zhuli.setName("朱莉");
        zhuli.setNumber_of_guests(5);
        zhuli.setPhone("2019686045");
        assertTrue(guestRepository.reserveGuest(zhuli));
    }
}