package com.Ben12345rocks.AdvancedCore.Util.Annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;

public class AnnotationHandler {

	public AnnotationHandler() {
	}

	@SuppressWarnings("unchecked")
	public void load(ConfigurationSection config, Object classToLoad) {
		Class<?> clazz = classToLoad.getClass();

		for (Field field : clazz.getDeclaredFields()) {
			try {
				field.setAccessible(true);

				ConfigDataString stringAnnotation = field.getAnnotation(ConfigDataString.class);
				if (stringAnnotation != null) {

					String defaultValue = stringAnnotation.defaultValue();
					if (defaultValue.isEmpty()) {
						try {
							String v = (String) field.get(classToLoad);
							defaultValue = v;
						} catch (Exception e) {

						}
					}
					String value = config.getString(stringAnnotation.path(),
							config.getString(stringAnnotation.secondPath(), defaultValue));

					field.set(classToLoad, value);

				}

				ConfigDataBoolean booleanAnnotation = field.getAnnotation(ConfigDataBoolean.class);
				if (booleanAnnotation != null) {
					boolean defaultValue = booleanAnnotation.defaultValue();
					if (!defaultValue) {
						try {
							boolean v = field.getBoolean(classToLoad);
							defaultValue = v;
						} catch (Exception e) {

						}

					}
					boolean value = config.getBoolean(booleanAnnotation.path(),
							config.getBoolean(booleanAnnotation.secondPath(), defaultValue));

					field.set(classToLoad, value);

				}

				ConfigDataInt intAnnotation = field.getAnnotation(ConfigDataInt.class);
				if (intAnnotation != null) {
					int defaultValue = intAnnotation.defaultValue();
					if (defaultValue == 0) {
						try {
							int v = field.getInt(classToLoad);
							defaultValue = v;
						} catch (Exception e) {

						}
					}
					int value = config.getInt(intAnnotation.path(),
							config.getInt(intAnnotation.secondPath(), defaultValue));

					field.set(classToLoad, value);

				}

				ConfigDataDouble doubleAnnotation = field.getAnnotation(ConfigDataDouble.class);
				if (doubleAnnotation != null) {
					double defaultValue = doubleAnnotation.defaultValue();
					if (defaultValue == 0) {
						try {
							double v = field.getDouble(classToLoad);
							defaultValue = v;
						} catch (Exception e) {

						}
					}
					double value = config.getDouble(doubleAnnotation.path(),
							config.getDouble(doubleAnnotation.secondPath(), defaultValue));

					field.set(classToLoad, value);

				}

				ConfigDataListString listAnnotation = field.getAnnotation(ConfigDataListString.class);
				if (listAnnotation != null) {
					ArrayList<String> defaultValue = new ArrayList<String>();
					try {
						ArrayList<String> v = (ArrayList<String>) field.get(classToLoad);
						defaultValue = v;
					} catch (Exception e) {

					}
					ArrayList<String> value = (ArrayList<String>) config.getList(listAnnotation.path(),
							config.getList(listAnnotation.secondPath(), defaultValue));

					field.set(classToLoad, value);
				}

				ConfigDataKeys setAnnotation = field.getAnnotation(ConfigDataKeys.class);
				if (setAnnotation != null) {
					Set<String> value = null;
					if (config.isConfigurationSection(setAnnotation.path())) {
						value = config.getConfigurationSection(setAnnotation.path()).getKeys(false);
					} else if (config.isConfigurationSection(setAnnotation.secondPath())) {
						value = config.getConfigurationSection(setAnnotation.secondPath()).getKeys(false);
					}
					field.set(classToLoad, value);
				}

				ConfigDataConfigurationSection confAnnotation = field
						.getAnnotation(ConfigDataConfigurationSection.class);
				if (confAnnotation != null) {
					ConfigurationSection value = null;
					if (config.isConfigurationSection(confAnnotation.path())) {
						value = config.getConfigurationSection(confAnnotation.path());
					} else if (config.isConfigurationSection(confAnnotation.secondPath())) {
						value = config.getConfigurationSection(confAnnotation.secondPath());
					}

					field.set(classToLoad, value);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
