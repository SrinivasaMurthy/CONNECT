package gov.hhs.fha.nhinc.patientdiscovery.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hl7.v3.RespondingGatewayPRPAIN201305UV02RequestType;
import org.hl7.v3.RespondingGatewayPRPAIN201306UV02ResponseType;

/**
 *
 * @author Neil Webb
 */
public class EntityPatientDiscoveryUnsecuredImpl
{
    private Log log = null;

    public EntityPatientDiscoveryUnsecuredImpl()
    {
        log = createLogger();
    }

    protected Log createLogger()
    {
        return LogFactory.getLog(getClass());
    }

    protected EntityPatientDiscoveryProcessor getEntityPatientDiscoveryProcessor()
    {
        return new EntityPatientDiscoveryProcessor();
    }

    public RespondingGatewayPRPAIN201306UV02ResponseType respondingGatewayPRPAIN201305UV02(RespondingGatewayPRPAIN201305UV02RequestType respondingGatewayPRPAIN201305UV02Request)
    {
        RespondingGatewayPRPAIN201306UV02ResponseType response = null;

        if(respondingGatewayPRPAIN201305UV02Request == null)
        {
            log.warn("RespondingGatewayPRPAIN201305UV02RequestType was null.");
        }
        else
        {
            EntityPatientDiscoveryProcessor processor = getEntityPatientDiscoveryProcessor();
            if(processor != null)
            {
                response = processor.respondingGatewayPRPAIN201305UV02(respondingGatewayPRPAIN201305UV02Request, respondingGatewayPRPAIN201305UV02Request.getAssertion());
            }
            else
            {
                log.warn("EntityPatientDiscoveryProcessor was null.");
            }
        }
        return response;
    }

}