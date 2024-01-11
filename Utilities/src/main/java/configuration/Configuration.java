package configuration;

import exceptions.FrameworkException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Configuration extends Properties {
    private static Configuration configuration;


    public static synchronized Configuration config() {
        if (configuration == null) {
            try {
                configuration = new Configuration();
            } catch (IOException e) {
                throw new FrameworkException("Failed to load property files!", e);
            }
        }

        return configuration;
    }

    private Configuration() throws IOException {
        super(System.getProperties());

        final List<String> classResources = Configuration.class.getClassLoader().resources("")
                .filter(resource -> resource.getFile().contains("classes/")).map(URL::getPath)
                .map(path -> path.replace("%20", " "))
                .collect(Collectors.toList());


        final List<String> resourceFiles =
                classResources.stream().flatMap(cr -> {
                    final List<File> files = Arrays.asList(new File(cr).listFiles());
                    return files.stream().map(File::getPath);
                }).collect(Collectors.toList());
        final List<String> propertyFiles = resourceFiles.stream().
                filter(rf -> rf.contains(".properties")).collect(Collectors.toList());
        for (final String propertyFilePath : propertyFiles) {
            super.load(new FileInputStream(propertyFilePath));
        }
    }

    @Override
    public String getProperty(String key) {
        Object oval = this.get(key);
        String sval = (oval instanceof String) ? (String) oval : null;
        Properties defaults;
        return ((defaults = this.defaults) != null) ? defaults.getProperty(key) : sval;
    }
}
