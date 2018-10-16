/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.reception.test;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider;
import solent.ac.uk.ood.examples.hotellock.secretkey.SecretKeyProviderImpl;

/**
 *
 * @author cgallen
 */
public class LoggingMessagesTest {
    
    public static final Logger LOG = LogManager.getLogger(LoggingMessagesTest.class);
    
    public static final Logger TRANSACTIONLOG = LogManager.getLogger("transaction-log");
    
    @Test
    public void hello() {
        try {
           
        String roomNumber = "100a";
        int issueNumber = 01;
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 1000 * 60 * 60 * 24); // 1 day later
         
        CardKey cardKey = new CardKey();
        cardKey.setRoomNumber(roomNumber);
        cardKey.setIssueNumber(issueNumber);
        cardKey.setStartDate(startDate);
        cardKey.setEndDate(endDate);
        System.out.println(cardKey);
        
        SecretKeyProvider keyProvider = new SecretKeyProviderImpl();
        String cardString = keyProvider.encodeCard(cardKey);
       
        CardKey decodedCardKey = keyProvider.decodeCard(cardString);
            
        } 
        catch (Exception ex) {
            LOG.error("JUST SAYING HELLO ERROR MESSAGE - the following stack trace is deliberate: ", ex);
        }
    }
    
    @Test
    public void testTransactionLog() {
        TRANSACTIONLOG.info("door opened");
    }
}
