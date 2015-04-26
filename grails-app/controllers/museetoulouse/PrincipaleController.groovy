package museetoulouse

class PrincipaleController {

    RechercheMuseeService rechercheMuseeService
    SessionService sessionService

    def index() {
        def listeMussesPreferes = sessionService.getListeMuseesPreferes (session)
        [listeMussesPreferes : listeMussesPreferes]

    }

    def recherche() {
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)
        def offsetTmp = params.int('offset') ?: 0
        def museeList = rechercheMuseeService.rechercheMusees(params.nomMusee, params.codePostal, params.nomRue, 5, offsetTmp)
        params.max = 5;
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.getTotalCount(), params: params, listeMussesPreferes: listeMussesPreferes])
    }

    def ajouterMuseesPreferes(){
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)

        if(params.id != null){
            sessionService.ajouterMuseesPreferes(session,params.int('id'))
        }
        redirect(action: 'index')
    }
    def supprimerMusee(){
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)

        if(params.id != null){
            sessionService.supprimerMusee(session, params.int('id'))
        }
        redirect(action: 'index')
    }

}