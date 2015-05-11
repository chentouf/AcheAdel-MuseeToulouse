package museetoulouse

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class RechercheMuseeService {

    def serviceMethod() {

    }
    def rechercheMusees(String unNom, String unCodePostal,String uneState, String uneRue,int maxP, int offsetP) {
        def criteria = Musee.createCriteria()
        def res = criteria.list (max: maxP, offset: offsetP){
            setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
            if (unNom) {
                like 'nom', "%${unNom}%"
            }
            if (unCodePostal) {
                adresse {
                    like 'codePostal', "${unCodePostal}"
                }
            }
            if (uneState) {
                adresse {
                    like 'state', "%${uneState}%"
                }
            }
            if (uneRue) {
                adresse {
                    like 'rue', "%${uneRue}%"
                }
            }
        }
        res
    }
}
