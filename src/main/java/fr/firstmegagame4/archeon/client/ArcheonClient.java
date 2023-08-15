package fr.firstmegagame4.archeon.client;

import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingClientModInitializer;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityRenderers;
import fr.firstmegagame4.archeon.client.init.ArcheonRenderLayers;
import fr.firstmegagame4.archeon.client.init.ArcheonScreens;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArcheonClient implements MModdingClientModInitializer {

	@Nullable
	@Override
	public Config getClientConfig() {
		return null;
	}

	@Override
	public List<ClientElementsInitializer> getClientElementsInitializers() {
		List<ClientElementsInitializer> clientElementsInitializers = new ArrayList<>();
		clientElementsInitializers.add(new ArcheonRenderLayers());
		clientElementsInitializers.add(new ArcheonEntityModelLayers());
		clientElementsInitializers.add(new ArcheonEntityRenderers());
		clientElementsInitializers.add(new ArcheonScreens());
		return clientElementsInitializers;
	}

	@Override
	public void onInitializeClient(AdvancedModContainer mod) {}
}
