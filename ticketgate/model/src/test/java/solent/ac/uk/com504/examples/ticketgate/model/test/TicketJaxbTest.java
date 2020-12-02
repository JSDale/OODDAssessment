/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.com504.examples.ticketgate.model.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import solent.ac.uk.com504.examples.ticketgate.model.dto.Ticket;
import static org.junit.Assert.*;
import org.junit.Test;
import solent.ac.uk.com504.examples.ticketgate.model.util.DateTimeAdapter;

/**
 * TEST THAT ticket.toXML and ticket.fromXML both work
 * 
 * create and populate a ticket using new ticket()
 * convert the ticket to an xml string
 * convert the xml string back to a new  ticket
 * check that the data in the two tickets are the same
 * 
 * @author cgallen
 */
public class TicketJaxbTest {

     /**
     * Test that a ticket can be marshalled and un-marshalled to xml using Ticket.toXML() and Ticket.fromXML methods
     */
    @Test
    public void testTicketXML() {
         //TODO ADD TEST CODE HERE

    }
    
    @Test 
    public void testGetTicketFromXml(){
        String xmlTicket = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                                                "<ticket>\n" +
                                                "    <zones>1</zones>\n" +
                                                "    <startStation>Luton</startStation>\n" +
                                                "    <encodedKey>HPYxLpS23SSkSj1ux0DNhTgCO883/0scVFxQ3V/SYPSrQfCQC71JJoGK0Q8WgIRyKvmqzTaJ6rxxQGtPru6SKJhALAxed7SbcFF5hk4qCZq3KK4DESGlLd2pJfeXeAlUJzH2v7yI9pBNGv+FQ2IhQpn9oXr71tiKa8MtpQ5k1ds=</encodedKey>\n" +
                                                "    <validFrom>02-12-2020 10:15:01</validFrom>\n" +
                                                "    <validTo>03-12-2020 10:15:01</validTo>\n" +
                                                "</ticket>";
        
         //GateEntryService gateEntryService = ServiceFactoryImpl.getGateEntryService();
         
         Ticket gatheredTicket = Ticket.fromXML(xmlTicket);
        
         Ticket createdTicket = new Ticket();
         createdTicket.setZones("1");
         createdTicket.setStartStation("Luton");
         DateFormat df = new SimpleDateFormat(DateTimeAdapter.DATE_FORMAT);
         
         try{
           Date  validFrom = df.parse("02-12-2020 10:15:01");
           createdTicket.setValidFrom(validFrom);
           Date validTo = df.parse("03-12-2020 10:15:01");
           createdTicket.setValidTo(validTo);
         }
         catch(Exception ex)
         {
             System.out.print(ex.getMessage());
         }
         
         createdTicket.setEncodedKey("HPYxLpS23SSkSj1ux0DNhTgCO883/0scVFxQ3V/SYPSrQfCQC71JJoGK0Q8WgIRyKvmqzTaJ6rxxQGtPru6SKJhALAxed7SbcFF5hk4qCZq3KK4DESGlLd2pJfeXeAlUJzH2v7yI9pBNGv+FQ2IhQpn9oXr71tiKa8MtpQ5k1ds=");
         
         Assert.assertEquals(createdTicket.getContent(), gatheredTicket.getContent());
         
    }

}
