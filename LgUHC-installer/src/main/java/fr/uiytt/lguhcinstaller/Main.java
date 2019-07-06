package fr.uiytt.lguhcinstaller;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		String path;
		String charpath;
		if(SystemUtils.IS_OS_WINDOWS) {
			path = this.getDataFolder().getAbsolutePath().replace("\\LgUHC-installer","");
			charpath = "\\";
		}else {
			path = this.getDataFolder().getAbsolutePath().replace("/LgUHC-installer","");
			charpath = "/";
		}
		getLogger().info("Detection des dependances");
		boolean ok;
		ok = true;
		if(getServer().getPluginManager().getPlugin("Skript") == null) {
			ok = false;
			getLogger().fine("Skript not found, Downloading...");
			ExternalFile Skript = new ExternalFile("https://github.com/SkriptLang/Skript/releases/download/2.3.7/Skript.jar", "Skript.jar");
			String check = Skript.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("Skellett") == null) {
			ok = false;
			getLogger().fine("Skellett not found, Downloading...");
			ExternalFile Skellett = new ExternalFile("https://skripttools.net/dl/Skellett+1.9.6b.jar", "Skellett.jar");
			String check = Skellett.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("TuSKe") == null) {
			ok = false;
			getLogger().fine("Tuske not found, Downloading...");
			ExternalFile TuSKe = new ExternalFile("https://skripttools.net/dl/TuSKe+1.8.3-PikachuPatch-v3.jar", "TuSKe 1.8.3-PikachuPatch-v3.jar");
			String check = TuSKe.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("MundoSK") == null) {
			ok = false;
			getLogger().fine("MundoSK not found, Downloading...");
			ExternalFile MundoSK = new ExternalFile("https://skripttools.net/dl/MundoSK+1.8.6-BETA.57.jar", "MundoSK 1.8.6-BETA.57.jar");
			String check = MundoSK.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("SkQuery") == null) {
			ok = false;
			getLogger().fine("SkQuery not found, Downloading...");
			ExternalFile SkQuery = new ExternalFile("https://skripttools.net/dl/SkQuery-Lime+3.6.5.jar", "SkQuery-Lime 3.6.5.jar");
			String check = SkQuery.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("Essentials") == null) {
			ok = false;
			getLogger().fine("EssentialsX not found, Downloading...");
			ExternalFile Essentials = new ExternalFile("https://ci.ender.zone/job/EssentialsX/lastStableBuild/artifact/Essentials/target/EssentialsX-2.17.0.3.jar", "EssentialsX-2.17.0.3.jar");
			String check = Essentials.downloadFile(path);
			if(check !="OK") {
				getLogger().warning(check);
			}
		}
		if(getServer().getPluginManager().getPlugin("EssentialsChat") == null) {
			ok = false;
			getLogger().fine("EssentialsXChat not found, Downloading...");
			ExternalFile EssentialsChat = new ExternalFile("https://ci.ender.zone/job/EssentialsX/lastStableBuild/artifact/EssentialsChat/target/EssentialsXChat-2.17.0.3.jar", "EssentialsXChat-2.17.0.3.jar");
			String check = EssentialsChat.downloadFile(path);
			if(check !="OK") {
				getLogger().warning("Lien non fonctionel " + check);
			}
		}
		
		if (ok == false) {
			getLogger().warning("Merci de relancer le serveur pour que le Lg-UHC se lance correctement");
		}else {
			File tmpDir = new File(path + charpath + "Skript");
			if (!tmpDir.isDirectory()) {
				tmpDir.mkdir();
			}
			File tmpDir1 = new File(path + charpath + "Skript" + charpath + "scripts");
			if (!tmpDir1.isDirectory()) {
				tmpDir1.mkdir();
			}
			File tmpFile = new File(path + charpath + "Skript" + charpath + "scripts" + charpath + "Lg-UHC.sk");
			ok = true;
			if (!tmpFile.isFile()) {
				getLogger().fine("Downloading Lg-UHC.sk");
				ExternalFile lgUHC = new ExternalFile("https://raw.githubusercontent.com/uiytt/Lg-UHC/master/Lg-UHC.sk", "Lg-UHC.sk");
				String check = lgUHC.downloadFile(path + charpath + "Skript" + charpath + "scripts");
				
				if(check !="OK") {
					getLogger().warning(check);
					ok = false;
				}
			}
			File tmpFile1 = new File(path + charpath + "Skript" + charpath + "config.sk");
			if (!tmpFile1.isFile()) {
				getLogger().fine("Downloading config.sk");
				ExternalFile config = new ExternalFile("https://raw.githubusercontent.com/uiytt/Lg-UHC/master/config.sk", "config.sk");
				String check = config.downloadFile(path + charpath + "Skript");
				if(check !="OK") {
					getLogger().warning(check);
					ok = false;
				}
			}
		if(ok == true) {
				getLogger().info("All done, you can delete this plugin.");
			}
			}
		
	}
	
	@Override
	public void onDisable() {
		
	}
}
