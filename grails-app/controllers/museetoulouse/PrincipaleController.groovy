package museetoulouse

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class PrincipaleController {

    RechercheMuseeService rechercheMuseeService
    SessionService sessionService
    @Secured("IS_AUTHENTICATED_FULLY")
    def index() {
        def listeMussesPreferes = sessionService.getListeMuseesPreferes (session)
        [listeMussesPreferes : listeMussesPreferes]

    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def recherche() {
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)
        def offsetTmp = params.int('offset') ?: 0
        def museeList = rechercheMuseeService.rechercheMusees(params.nomMusee, params.codePostal, params.nomRue, params.state , 5, offsetTmp)
        params.max = 5;
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.getTotalCount(), params: params, listeMussesPreferes: listeMussesPreferes])
    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def ajouterMuseesPreferes(){
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)

        if(params.id != null){
            sessionService.ajouterMuseesPreferes(session,params.int('id'))
        }
        redirect(action: 'index')
    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def supprimerMusee(){
        def listeMussesPreferes = sessionService.getListeMuseesPreferes(session)

        if(params.id != null){
            sessionService.supprimerMusee(session, params.int('id'))
        }
        redirect(action: 'index')
    }

}