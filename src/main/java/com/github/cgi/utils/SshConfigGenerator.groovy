package com.github.cgi.utils

/**
 * Created by cgi on 12.08.14.
 */
class SshConfigGenerator {
    public String generateSshConfig(String alias, String hostName, String user, String keyFile){
        String template =
        "Host  ${alias}\n" +
                "  HostName ${hostName}\n" +
                "  User ${user}\n" +
                "  IdentityFile ${keyFile}\n" +
                "\n"
        return template;
    }

    public String generateUsersSshConfig(List<String> aliases, String hostName, List<String> users, String keyFile){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < aliases.size(); i++) {
            sb.append(generateSshConfig(aliases[i], hostName, users[i], keyFile));
        }
        return sb.toString();
    }

    public String generateSshConfigWraped(String baseAlias, String hostName, String user){


        def alias = "m9-pgu-" + baseAlias + "-" + user;
        hostName = "m9-pgu-" + baseAlias;

        return generateSshConfig(alias, hostName, user, "~/.ssh/id_dsa_gate");
    }


    public String genegateHostsConfig(String ip, String... aliases){
        return ip + "\t" + aliases.collect { s -> "m9-pgu-" + s}.join(" ");
    }

    public static void main(String ... args){
        SshConfigGenerator g = new SshConfigGenerator();
        LinkedList<Map<String, String>> data = new LinkedList<>();

        println g.genegateHostsConfig("192.168.1.10", "d00pgudb01")
        println g.genegateHostsConfig("192.168.1.11", "d00jms01")
        println g.genegateHostsConfig("192.168.1.12", "d00jms02")
        println g.genegateHostsConfig("192.168.1.13", "d00commapp01")
        println g.genegateHostsConfig("192.168.1.14", "d00pguapp01")
        println g.genegateHostsConfig("192.168.1.15", "d00worker01")
        println g.genegateHostsConfig("192.168.1.16", "d00frgu01")
        println g.genegateHostsConfig("192.168.1.17", "d00pguadm01")
        println g.genegateHostsConfig("192.168.1.18", "d00pgudesigner01")
        println g.genegateHostsConfig("192.168.1.19", "d00pguweb01")
        println g.genegateHostsConfig("192.168.1.20", "d00pguweb02")

        println()
        println()

        print g.generateSshConfigWraped("d00pgudb01", "192.168.1.10", "oracle" );
        print g.generateSshConfigWraped("d00pgudb01", "192.168.1.10", "root" );

        print g.generateSshConfigWraped("d00jms01", "192.168.1.11", "jmsa" );
        print g.generateSshConfigWraped("d00jms01", "192.168.1.11", "root" );

        print g.generateSshConfigWraped("d00jms02", "192.168.1.12", "jmsa" );
        print g.generateSshConfigWraped("d00jms02", "192.168.1.12", "root" );

        print g.generateSshConfigWraped("d00commapp01", "192.168.1.13", "commapp" );
        print g.generateSshConfigWraped("d00commapp01", "192.168.1.13", "pds" );
        print g.generateSshConfigWraped("d00commapp01", "192.168.1.13", "assertion" );
        print g.generateSshConfigWraped("d00commapp01", "192.168.1.13", "root" );

        print g.generateSshConfigWraped("d00pguapp01", "192.168.1.14", "pguapp" );
        print g.generateSshConfigWraped("d00pguapp01", "192.168.1.14", "solr" );
        print g.generateSshConfigWraped("d00pguapp01", "192.168.1.14", "juddi" );
        print g.generateSshConfigWraped("d00pguapp01", "192.168.1.14", "config" );
        print g.generateSshConfigWraped("d00pguapp01", "192.168.1.14", "root" );

        print g.generateSshConfigWraped("d00worker01", "192.168.1.15", "worker1" );
        print g.generateSshConfigWraped("d00worker01", "192.168.1.15", "worker2" );
        print g.generateSshConfigWraped("d00worker01", "192.168.1.15", "root" );

        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "inc" );
        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "ws" );
        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "pv" );
        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "sm" );
        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "sr" );
        print g.generateSshConfigWraped("d00frgu01", "192.168.1.16", "root" );

        print g.generateSshConfigWraped("d00pguadm01", "192.168.1.17", "techportal" );
        print g.generateSshConfigWraped("d00pguadm01", "192.168.1.17", "root" );

        print g.generateSshConfigWraped("d00pgudesigner01", "192.168.1.18", "designer" );
        print g.generateSshConfigWraped("d00pgudesigner01", "192.168.1.18", "root" );

        print g.generateSshConfigWraped("d00pguweb01", "192.168.1.19", "pguweb" );
        print g.generateSshConfigWraped("d00pguweb01", "192.168.1.19", "root" );

        print g.generateSshConfigWraped("d00pguweb02", "192.168.1.20", "pguweb" );
        print g.generateSshConfigWraped("d00pguweb02", "192.168.1.20", "root" );
    }
}