package org.archive.extract;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import junit.framework.TestCase;


public class RealCDXExtractorOutputTest extends TestCase {

    public void testEscapeResolvedUrl() throws Exception {
	String context ="http://www.uni-giessen.de/cms/studium/dateien/informationberatung/merkblattpdf";
	String spec = "http://fss.plone.uni-giessen.de/fß/studium/dateien/informationberatung/merkblattpdf/file/Mérkblatt zur Gestaltung von Nachteilsausgleichen.pdf?föo=bar#änchor";
	String escaped = RealCDXExtractorOutput.resolve(context, spec);
	assertTrue(escaped.indexOf(" ") < 0);
	URI parsed = new URI(escaped);
	assertEquals("änchor", parsed.getFragment());
    }

    public void testNoDoubleEscaping() throws Exception {
	String spec = "https://www.google.com/search?q=java+escape+url+spaces&ie=utf-8&oe=utf-8";
	String resolved = RealCDXExtractorOutput.resolve(spec, spec);
	assertTrue(spec.equals(resolved));
    }
    
    public void ignoreTestMoreBrokenUrls() throws Exception {
	String[] tests = new String[] { "mailto: john.doe@uni-oldenburg.de", 
	"mailto:john.doe @Informatik.Uni-Oldenburg.DE",
	"mailto:john.doe@blicher Tbinger Anhang",
	"mailto:john.doe@uni-oldenburg.de?subject=Antrag auf SAP Zugang",
	"E:/SmartSource Data Collector/util/content/wt_dcs.gif",
	"ttp://find.galegroup.com/bncn/infomark.do?serQuery=Locale%28en%2C%2C%29%3AFQE%3D%28JX%2CNone%2C16%29%22Dublin Gazette%22%24&queryType=PH&type=pubIssues&prodId=BBCN&version=1.0&source=library"};
	for (String test : tests) {
		String escaped = RealCDXExtractorOutput.resolve(null, test);
		System.out.println(test + " -> " + escaped);
		assertTrue(escaped.indexOf(" ") < 0);
	}
    }
}
