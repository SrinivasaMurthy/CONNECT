/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.hhs.fha.nhinc.docquery.nhin.deferred.response;

import gov.hhs.fha.nhinc.service.WebServiceHelper;
import gov.hhs.healthit.nhin.DocQueryAcknowledgementType;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author JHOPPESC
 */
@WebService(serviceName = "RespondingGateway_QueryDeferredResponse_Service", portName = "RespondingGateway_QueryDeferredResponse_Port_Soap", endpointInterface = "ihe.iti.xds_b._2007.RespondingGatewayQueryDeferredResponsePortType", targetNamespace = "urn:ihe:iti:xds-b:2007", wsdlLocation = "WEB-INF/wsdl/NhinDocQueryDeferredResponse/NhinDocQueryDeferredResponse.wsdl")
@BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public class NhinDocQueryDeferredResponse
{

    @Resource
    private WebServiceContext context;
    private static final Log log = LogFactory.getLog(NhinDocQueryDeferredResponse.class);

    public gov.hhs.healthit.nhin.DocQueryAcknowledgementType respondingGatewayCrossGatewayQuery(oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse body)
    {
        DocQueryAcknowledgementType response = null;
        WebServiceHelper oHelper = new WebServiceHelper();
        NhinDocQueryDeferredResponseOrchImpl proxy = new NhinDocQueryDeferredResponseOrchImpl();
        try
        {
            if (body != null)
            {
                response = (DocQueryAcknowledgementType) oHelper.invokeSecureDeferredResponseWebService(proxy, proxy.getClass(), "respondingGatewayCrossGatewayQuery", body, context);
            } else
            {
                log.error("Failed to call the web orchestration (" + proxy.getClass() + ".respondingGatewayCrossGatewayQuery).  The input parameter is null.");
            }
        } catch (Exception e)
        {
            log.error("Failed to call the web orchestration (" + proxy.getClass() + ".respondingGatewayCrossGatewayQuery).  An unexpected exception occurred.  " +
                    "Exception: " + e.getMessage(), e);
        }

        return response;
    }
}