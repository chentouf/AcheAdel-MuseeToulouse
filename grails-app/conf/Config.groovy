// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {

    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
    development
            {
                grails.serverURL   = "http://localhost:8080/${appName}"
                /*
                 * En mettant ${appName} on est sur que sur le tag form action=/Workflow/achat/besoinOut
                 * "/Work
                 */
                isae.repertoireDoc = './docs'
                grails.plugin.springsecurity.cas.active			= false
            }
    test
            {
                //grails.serverURL   = "http://ori-oai:8195/${appName}-${grails.util.Environment.current.name}"
                //grails.serverURL   = "http://ori-oai-int:8195/${appName}Test"
                //isae.repertoireDoc = '/usr/local/workflows/test'
                grails.serverURL   = "http://si-devel.isae.fr/${appName}Test"
                isae.repertoireDoc = '/usr/local/tomcat/fichiersWorkflow/test'
                grails.plugin.springsecurity.cas.active			= true
            }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}
grails.resources.modules = {
    application {
        resource url:'js/application.js'
    }

    bootstrap {
        resource url:'less/custom-bootstrap.less',attrs:[rel: "stylesheet/less", type:'css']
        dependsOn 'jquery'
        dependsOn 'bootstrapJs'
    }

    bootstrapJs {
        resource url:'js/bootstrap/bootstrap-affix.js'
        resource url:'js/bootstrap/bootstrap-alert.js'
        resource url:'js/bootstrap/bootstrap-button.js'
        resource url:'js/bootstrap/bootstrap-carousel.js'
        resource url:'js/bootstrap/bootstrap-collapse.js'
        resource url:'js/bootstrap/bootstrap-dropdown.js'
        resource url:'js/bootstrap/bootstrap-modal.js'
        resource url:'js/bootstrap/bootstrap-popover.js'
        resource url:'js/bootstrap/bootstrap-scrollspy.js'
        resource url:'js/bootstrap/bootstrap-tab.js'
        resource url:'js/bootstrap/bootstrap-tooltip.js'
        resource url:'js/bootstrap/bootstrap-transition.js'
        resource url:'js/bootstrap/bootstrap-typeahead.js'
    }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.errors.login.fail	= "Désolé, votre nom d'utilisateur/mot de passe est incorrect."
grails.plugin.springsecurity.ldap.context.managerDn = ''
grails.plugin.springsecurity.ldap.context.managerPassword = ''
grails.plugin.springsecurity.userLookup.userDomainClassName = 'util.museetoulouse.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'util.museetoulouse.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'util.museetoulouse.auth.Role'
grails.plugin.springsecurity.useSwitchUserFilter = true
grails.plugin.springsecurity.switchUser.switchUserUrl = '/j_spring_security_switch_user'
grails.plugin.springsecurity.switchUser.exitUserUrl = '/j_spring_security_exit_user'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/assets/**':                     ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll'],
    '/j_spring_security_switch_user': ['ROLE_W_SWITCH_USER', 'isFullyAuthenticated()'],
    '/j_spring_security_exit_user':   ['permitAll'],
    '/dbconsole/**':                 ['permitAll']
]

