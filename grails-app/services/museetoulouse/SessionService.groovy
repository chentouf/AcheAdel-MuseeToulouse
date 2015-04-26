package museetoulouse

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
import javax.servlet.http.HttpSession
@Transactional
class SessionService {

    def getListeMuseesPreferes(GrailsHttpSession session) {
        if (session.listeMusee == null) {
            session.listeMusee = new TreeMap<String,Integer>()
        }
        session.listeMusee
    }

    def ajouterMuseesPreferes(GrailsHttpSession session, int id) {
        def museeInstance = Musee.findById(id)
        if (museeInstance != null) {
            def liste = session.listeMusee
            if (!liste.containsValue(new Integer(id))) {
                liste.put(museeInstance.nom,new Integer(id))
                session.listeMusee = liste
            }
        }
    }

    def supprimerMusee(GrailsHttpSession session, int id) {
        def museeInstance = Musee.findById(id)
        if (museeInstance != null) {
            def liste = session.listeMusee
            liste.remove(museeInstance.nom)
            session.listeMusee = liste
        }
    }
}