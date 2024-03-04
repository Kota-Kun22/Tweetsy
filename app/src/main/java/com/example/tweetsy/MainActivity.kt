package com.example.tweetsy

import android.os.Bundle
import androidx.compose.material3.TopAppBarColors

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.Screens.CategoryScreen
import com.example.tweetsy.Screens.DetailScreen
import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tweetsyAPI: TweetsyAPI
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsyTheme {
                Scaffold(
                    topBar = {
                    TopAppBar(
                        title = { Text(text = "TWEETSY") },
                        colors= TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Color.Black,
                            titleContentColor = Color.White)
                        )

                }) {
                    
                    Box(modifier = Modifier
                        .padding(it)
                        .background(MaterialTheme.colorScheme.background)
                    )
                    {
                        App()

                    }
                }
            }
        }
    }
}
@Composable
fun App()
{
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="category" )
    {
        composable(route = "category")
        {
            CategoryScreen(onClick = {
                navController.navigate("detail/${it}")
            })
        }
        composable(route = "detail/{category}",
            arguments = listOf(navArgument("category")
            {
                type = NavType.StringType
            }
            )
        ) {
            DetailScreen()
        }

    }
}

