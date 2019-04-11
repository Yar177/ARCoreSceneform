package com.yarsher.at.arcoresceneform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable bearRenderable, catRenderable, cowRenderable, dogRenderable, elephantRenderable, ferretRenderable,
            hippoRenderable, horseRenderable, koalaRenderable, lionRenderable, reindeerRenderable, wolverineRenderable;
    ImageView bearImg, catImg, cowImg, dogImg, elephantImg, ferretImg, hippoImg, horseImg, koalaImg, lionImg, reindeerImg, wolverineImg;

    View arrayView[];
    ViewRenderable name_animal;

    int selected =1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        bearImg = (ImageView)findViewById(R.id.bear);
        catImg = (ImageView)findViewById(R.id.cat);
        cowImg = (ImageView)findViewById(R.id.cow);
        dogImg = (ImageView)findViewById(R.id.dog);
        elephantImg = (ImageView)findViewById(R.id.elephant);
        ferretImg = (ImageView)findViewById(R.id.ferret);
        hippoImg = (ImageView)findViewById(R.id.hippopotamus);
        horseImg = (ImageView)findViewById(R.id.horse);
        koalaImg = (ImageView)findViewById(R.id.koala_bear);
        lionImg = (ImageView)findViewById(R.id.lion);
        reindeerImg = (ImageView)findViewById(R.id.reindeer);
        wolverineImg = (ImageView)findViewById(R.id.wolverine);

        setArrayView();

        setClickListener();

        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {

                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode, selected);

            }
        });


    }

    private void setupModel() {
        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Bear model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cow model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load dog model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load elephant model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load ferret model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load hippo model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load horse model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load koala model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load lion model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load reindeer model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load wolverine model ", Toast.LENGTH_LONG).show();
                            return null;
                        }
                );

    }






    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1){
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

        }
    }

    private void setClickListener() {
        for (int i=0; i<arrayView.length; i++){
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bearImg, catImg, cowImg, dogImg, elephantImg, ferretImg, hippoImg, horseImg, koalaImg, lionImg, reindeerImg, wolverineImg
        };

    }


    @Override
    public void onClick(View v) {

    }
}
