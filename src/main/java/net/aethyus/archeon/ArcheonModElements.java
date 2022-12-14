/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.aethyus.archeon;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class ArcheonModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();

	public ArcheonModElements() {
		sounds.put(new ResourceLocation("archeon", "pe4k"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "pe4k")));
		sounds.put(new ResourceLocation("archeon", "devouring"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "devouring")));
		sounds.put(new ResourceLocation("archeon", "ambient"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "ambient")));
		sounds.put(new ResourceLocation("archeon", "dotted_sky"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "dotted_sky")));
		sounds.put(new ResourceLocation("archeon", "sunny"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "sunny")));
		sounds.put(new ResourceLocation("archeon", "wild_breath"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "wild_breath")));
		sounds.put(new ResourceLocation("archeon", "genesis"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "genesis")));
		sounds.put(new ResourceLocation("archeon", "hoxa"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "hoxa")));
		sounds.put(new ResourceLocation("archeon", "no_ones_around"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "no_ones_around")));
		sounds.put(new ResourceLocation("archeon", "brile"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "brile")));
		sounds.put(new ResourceLocation("archeon", "geometric_fall"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "geometric_fall")));
		sounds.put(new ResourceLocation("archeon", "reside"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "reside")));
		sounds.put(new ResourceLocation("archeon", "rising"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "rising")));
		sounds.put(new ResourceLocation("archeon", "parallelify"), new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "parallelify")));
		sounds.put(new ResourceLocation("archeon", "archeon_christmas"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "archeon_christmas")));
		sounds.put(new ResourceLocation("archeon", "catalyst.ambient"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "catalyst.ambient")));
		sounds.put(new ResourceLocation("archeon", "catalyst.hit"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "catalyst.hit")));
		sounds.put(new ResourceLocation("archeon", "the_nature_core"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "the_nature_core")));
		sounds.put(new ResourceLocation("archeon", "the_nature_core_end"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("archeon", "the_nature_core_end")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("archeon").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == ArcheonModElements.ModElement.class)
						elements.add((ArcheonModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(ArcheonModElements.ModElement::initElements);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	private int messageID = 0;

	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		ArcheonMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}

	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}

		protected final ArcheonModElements elements;
		protected final int sortid;

		public ModElement(ArcheonModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
