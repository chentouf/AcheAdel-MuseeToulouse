package museetoulouse

import grails.transaction.Transactional

@Transactional
class RechercheMuseeService {

    def serviceMethod() {

    }
    List<Musee> rechercheMusees(String unNom, String unCodePostal, String uneRue) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (unNom) {
                like 'nom', "%${unNom}%"
            }
            if (unCodePostal) {
                adresse {
                    like 'codePostal', "${unCodePostal}"
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
