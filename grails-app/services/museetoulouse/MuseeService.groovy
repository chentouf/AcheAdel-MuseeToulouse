package museetoulouse

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def serviceMethod() {

    }
    Musee musee1
    Musee musee2
    Musee musee3
    Musee musee4
    Musee musee5
    Musee musee6
    Musee musee7
    Musee musee8
    Musee musee9
    Musee musee10
    Musee musee11
    Musee musee12

    Adresse adr1
    Adresse adr2
    Adresse adr3
    Adresse adr4
    Adresse adr5
    Adresse adr6
    Adresse adr7
    Adresse adr8
    Adresse adr9
    Adresse adr10
    Adresse adr11
    Adresse adr12

    Gestionnaire gest1
    Gestionnaire gest2
    Gestionnaire gest3
    Gestionnaire gest4


    def createJeuTest() {
        gest1 = new Gestionnaire(nom: 'Mairie de Toulouse - DGA Culture')
        gest2 = new Gestionnaire(nom: 'Association')
        gest3 = new Gestionnaire(nom: 'Autre institution publique')
        gest4 = new Gestionnaire(nom: 'Structure commerciale')

        adr1 = new Adresse(numero: '2',rue: 'RUE DES ARCHIVES',codePostal: '31500',ville: 'TOULOUSE' )
        adr2 = new Adresse(numero: '5',rue: 'RUE SAINT PANTALEON',codePostal: '31000',ville: 'TOULOUSE' )
        adr3 = new Adresse(numero: '69',rue: 'RUE PARGAMINIERES',codePostal: '31000',ville: 'TOULOUSE' )
        adr4 = new Adresse(numero: '31',rue: 'RUE DE LA FONDERIE',codePostal: '31000',ville: 'TOULOUSE' )
        adr5 = new Adresse(numero: '',rue: 'RUE MONTMORENCY',codePostal: '31200',ville: 'TOULOUSE' )
        adr6 = new Adresse(numero: '2',rue: 'RUE VIGUERIE',codePostal: '31300',ville: 'TOULOUSE' )
        adr7 = new Adresse(numero: '21',rue: 'RUE DE METZ',codePostal: '31000',ville: 'TOULOUSE' )
        adr8 = new Adresse(numero: '2',rue: 'RUE TRIPIERE',codePostal: '31000',ville: 'TOULOUSE' )
        adr9 = new Adresse(numero: '2',rue: 'RUE VIGUERIE',codePostal: '31300',ville: 'TOULOUSE' )
        adr10 = new Adresse(numero: '7',rue: 'RUE DU MAY',codePostal: '31000',ville: 'TOULOUSE' )
        adr11 = new Adresse(numero: '',rue: 'RUE DU JAPON',codePostal: '31400',ville: 'TOULOUSE' )
        adr12 = new Adresse(numero: '13',rue: 'RUE DE LA PLEAU',codePostal: '31000',ville: 'TOULOUSE' )

        musee1 = new Musee(adresse: adr1,
                gestionnaire: gest1,
                nom: 'ARCHIVES MUNICIPALES TOULOUSE',
                horairesOuverture: 'Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.',
                accesBus: '36, 38',
                accesMetro: 'Roseraie (A)').save()
        musee2 = new Musee(adresse: adr2,
                gestionnaire: gest2,
                nom: 'CMAV - CENTRE MERIDIONAL DE L\'ARCHITECTURE DE LA VILLE',
                horairesOuverture: 'Ouvert du mardi au samedi de 13h à 19hfermé les dimanches, jours fériés et du 1er au 15 août',
                accesBus: 'ncv, 2, 10, 12, 14, 38, 78 et 80',
                accesMetro: 'Capitole (A), Jean Jaurès (B)').save()
        musee3 = new Musee(adresse: adr3,
                gestionnaire: gest1,
                nom: 'ENSEMBLE CONVENTUEL DES JACOBINS',
                horairesOuverture: 'Ouvert tous les jours de 9h à 19h.',
                accesBus: 'NCV, 2, 10, 12, 14, 38, 78, 80',
                accesMetro: 'Esquirol, Capitole (A)').save()
        musee4 = new Musee(adresse: adr4,
                gestionnaire: gest3,
                nom: 'INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE - SALLE TOLOSA',
                horairesOuverture: 'Ouvert le premier vendredi de chaque mois de 18h à 20h.',
                accesBus: '2, 38',
                accesMetro: 'Carmes (B)').save()
        musee5 = new Musee(adresse: adr5,
                gestionnaire: gest4,
                nom: 'L\'AEROTHEQUE',
                horairesOuverture: 'Ouvert le lundi et le mercredi de 14h à 17h et le mardi de 9h à 12h',
                accesBus: '15',
                accesMetro: '').save()
        musee6 = new Musee(adresse: adr6,
                gestionnaire: gest2,
                nom: 'MUSEE DE L\'HISTOIRE DE LA MEDECINE DE TOULOUSE',
                horairesOuverture: 'Ouvert tous les jeudi et vendredi de 11h à 17h, et le dimande de 10h à 18h.Visites guidées sur demande.',
                accesBus: '2, 10, 12, 14, 78, 80',
                accesMetro: 'Saint-Cyprien-République, Esquirol (A)').save()
        musee7 = new Musee(adresse: adr7,
                gestionnaire: gest1,
                nom: 'MUSEE DES AUGUSTINS - MUSEE DES BEAUX ARTS DE TOULOUSE',
                horairesOuverture: 'Tous les jours : 10h - 18h /  nocturne le mercredi jusqu\'à 21h.',
                accesBus: 'ncv, 2, 10, 14, 38, 78, 80',
                accesMetro: 'Esquirol (A) ou Carmes (B)').save()
        musee8 = new Musee(adresse: adr8,
                gestionnaire: gest2,
                nom: 'MUSEE DES COMPAGNONS',
                horairesOuverture: 'Le Mercredi et le 1er dimanche de chaque mois de 14h à 17h',
                accesBus: '2, 10, 12, 14, 38, 78, 80',
                accesMetro: 'Esquirol, Capitole (A)').save()
        musee9 = new Musee(adresse: adr9,
                gestionnaire: gest4,
                nom: 'MUSEE DES INSTRUMENTS DE MEDECINE DES HOPITAUX DE TOULOUSE',
                horairesOuverture: 'Ouvert tous les jeudi et vendredi de 13h à 17h. Ouvert le premier dimanche du mois.Visites guidées sur demande.',
                accesBus: '2, 10, 12, 14, 78, 80',
                accesMetro: 'Saint-Cyprien-République, Esquirol (A)').save()
        musee10 = new Musee(adresse: adr10,
                gestionnaire: gest2,
                nom: 'MUSEE DU VIEUX TOULOUSE',
                horairesOuverture: 'Ouvert tous les jours du 2 mai au 31 octobre de 14h00 à 18h00.Fermé le dimanche et jours fériés.',
                accesBus: '2, 10, 12, 14, 38, 78, 80',
                accesMetro: 'Esquirol, Capitole (A)').save()
        musee11 = new Musee(adresse: adr11,
                gestionnaire: gest1,
                nom: 'MUSEE GEORGES-LABIT',
                horairesOuverture: 'Musée ouvert de 10h à 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermeture hebdomadaire le mardi.Bibliothèque ouverte le lundi de 14h à 17h, le mardi et le mercredi : 9h-12h et 14h-17h.',
                accesBus: '10, 2, 27',
                accesMetro: 'François Verdier (B)').save()
        musee12 = new Musee(adresse: adr12,
                gestionnaire: gest1,
                nom: 'MUSEE PAUL-DUPUY - ARTS GRAPHIQUES ET ARTS DECORATIFS',
                horairesOuverture: 'Ouvert de 10h - 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermé le mardi et jours fériés.',
                accesBus: 'ncv, 2, 12, 52',
                accesMetro: 'Esquirol (A) Carmes (B)').save()
    }
}
