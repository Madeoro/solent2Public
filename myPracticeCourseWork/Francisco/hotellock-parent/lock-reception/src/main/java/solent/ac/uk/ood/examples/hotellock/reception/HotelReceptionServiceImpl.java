/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.reception;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService;
import solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider;

/**
 *
 * @author cgallen
 */
public class HotelReceptionServiceImpl implements HotelReceptionService {
   // public static final Logger LOG = LogManager.getLogger(LoggingMessagesTest.class);
    
    public static final Logger TRANSACTIONLOG = LogManager.getLogger("transaction-log");

    private SecretKeyProvider secretKeyProvider;
    
    @Override
    public String createCardCode(String roomNumber, Date startDate, Date endDate) {
        
        CardKey cardKey = new CardKey();
        
        roomNumber = cardKey.getRoomNumber();
        int issueNumber = cardKey.getIssueNumber();
        startDate = cardKey.getStartDate();
        endDate = cardKey.getEndDate();

   
        String cardString = secretKeyProvider.encodeCard(cardKey);
        return cardString;

        
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CardKey readCard(String cardCode) {
        CardKey decodedCardKey = secretKeyProvider.decodeCard(cardCode);
        return decodedCardKey;
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSecretKeyProvider(SecretKeyProvider secretKeyProvider) {
        this.secretKeyProvider= secretKeyProvider;
    }
    
}
