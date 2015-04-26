package museetoulouse


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DemandeVisiteController {


    SessionService sessionService
    DemandeVisiteService demandeVisiteService

    def index(){
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)
        [listeMussesPreferes: listeMussesPreferes]
    }

    def demande(){
        Calendar c1 = GregorianCalendar.getInstance()
        c1.clear()
        c1.set(params.int('dateDebutPeriode_year') ?: 0, (params.int('dateDebutPeriode_month') ?: 0)-1, params.int('dateDebutPeriode_day') ?: 1);
        Calendar c2 = GregorianCalendar.getInstance()
        c2.clear()
        c2.set(params.int('dateFinPeriode_year') ?: 0, (params.int('dateFinPeriode_month') ?: 0)-1, params.int('dateFinPeriode_day') ?: 1);

        def dateDebutPeriode = c1.getTime()
        def dateFinPeriode = c2.getTime()

        def nbPersonnes = params.int('nbPersonnes') ?: 0
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)
        def listeMuseeInstance = new ArrayList<Musee>()

        def retourCreation

        if (listeMussesPreferes != null && !listeMussesPreferes.isEmpty()) {
            for (museeInstance in listeMussesPreferes) {
                listeMuseeInstance.add(Musee.findById(museeInstance.value))
            }

            retourCreation = demandeVisiteService.createDemande(listeMuseeInstance,dateDebutPeriode,dateFinPeriode,nbPersonnes)
            if (!retourCreation.hasErrors()) {
                [retourCreation: retourCreation.code]
            } else {
                render(view: 'index',model:[retourCreation: retourCreation,listeMussesPreferes: listeMussesPreferes])
            }
        }

    }

}
