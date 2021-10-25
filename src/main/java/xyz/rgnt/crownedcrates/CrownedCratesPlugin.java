package xyz.rgnt.crownedcrates;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.animations.IAnimationRepository;
import xyz.rgnt.crownedcrates.animations.actors.builder.IActorBuilder;
import xyz.rgnt.crownedcrates.animations.keyframes.builder.IKeyframeBuilder;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;
import xyz.rgnt.crownedcrates.crates.ICrateRepository;
import xyz.rgnt.crownedcrates.crates.builder.ICrateBuilder;
import xyz.rgnt.crownedcrates.rewards.IRewardRepository;

public class CrownedCratesPlugin extends JavaPlugin {

    // animation api
    {
        // create animation from keyframes
        final var anim = IAnimation.makeAnimation(
                IKeyframeBuilder.make()
                        .next(1)
                        .withRelRot(new Vector(0, 180, 0))
                        .next(10)
                        .withRelRot(new Vector(0, 360, 0))
                        .build()
        );

        // store it in animation repo
        final var animKey = new NamespacedKey(this, "basic_animation");
        final var animRepo = IAnimationRepository.makeAnimationRepository();
        animRepo.addAnimation(
                animKey,
                anim
        );

        // animation controller is required to step through animations
        final var animController = IAnimationController
                .makeWorldAnimationController(this);


        final Entity entityInWorld = null;
        animController.addActor(
                IActorBuilder.crateEntityActor(null, new NamespacedKey(this, "animee_0")),
                animRepo.getAnimation(animKey)
        );
        animController.start();
        ///..
    }

    // crates api
    {
        final Player player;
        final ICrateRepository crateRepo;
        final IRewardRepository rewardRepo;

        final var crate = ICrateBuilder
                .builder(this, new NamespacedKey(this, "basic_crate"))
                .withPermission(new Permission("crownedcrates.admin"))
                .withReward(rewardRepo.getReward(
                        new NamespacedKey(this, "rewards_diamonds")
                ))
                .withReward(rewardRepo.getReward(
                        new NamespacedKey(this, "rewards_goldbars")
                ))
                .build();


        crate.openTo(playerInstance, (reward) -> {
            // this is called once reward has been given to player.

            player.sendMessage(
                    Component.text("You just won! ")
                            .append(reward.getSylizedName())
                            .content(" from ")
                            .append(crate.getSylizedName())
            );
        });

    }


}
