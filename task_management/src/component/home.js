import React from 'react';
//import SearchAppBar from './Navbar';
import './home.css'
import { CardGroup, CarouselItem, Image } from 'react-bootstrap';
import NavbarComponent from './Navbar/NavbarComponent';
import Card from 'react-bootstrap/Card';
import Carousel from 'react-bootstrap/Carousel';
import FooterContent from './Footer/FooterContent';

function Home() {

  return (

    <div>
      <NavbarComponent />
      
      <div>
        <Carousel fade>
          <CarouselItem>
            <Image className='image' src='https://wallpaperaccess.com/full/3275858.jpg' />
            <Carousel.Caption>
              <h3 className='imageTitle'>Travel & Go</h3>
              <p className='imagePara'>Discover the world, find comfort in every corner.Your home away from home awaits, where every journey begins with a welcoming embrance.</p>
            </Carousel.Caption>
          </CarouselItem>
          <CarouselItem>
            <Image className='image' src='https://wallpaperaccess.com/full/3275861.jpg' />
            <Carousel.Caption>
              <h3 className='imageTitle'>Travel & Go</h3>
              <p className='imagePara'>Embark on a digital journey,where every click opens the door to new horizons.</p>
            </Carousel.Caption>
          </CarouselItem>
          <CarouselItem>
            <Image className='image' src='https://wallpaperaccess.com/full/3275856.jpg' />
            <Carousel.Caption>
              <h3 className='imageTitle'>Travel & Go</h3>
              <p className='imagePara'>
                Explore the globe on your timeline. Your next adventure is just a click away. Traveling made seamless, memories made online.
              </p>
            </Carousel.Caption>
          </CarouselItem>
        </Carousel>
      </div>
      <div className='cards'>
        <div className='card1'>
          <div className='cardImage'>
            <Card.Img variant="top" src="https://www.gtholidays.in/wp-content/uploads/2019/11/gt-hoildays-family-icon.png" />
          </div>
          <h4>Extremely Happy Travellers</h4>
          <p>Travel & Go holds record of great customer satisfaction and all customers are retained with us.</p>
        </div>
        <div className='card1'>
          <div className='cardImage'>
            <Card.Img variant="top" src="https://www.gtholidays.in/wp-content/uploads/2022/12/Experiences.png" />
          </div>
          <h4>Handcrafted Experiences</h4>
          <p>Each and every itinerary is customized according to the taste of the customers.</p>
        </div>
        <div className='card1'>
          <div className='cardImage'>
            <Card.Img variant="top" src="https://www.gtholidays.in/wp-content/uploads/2019/11/gt-hoildays-couple-icon.png" />
          </div>
          <h4>Abroad Trips</h4>
          <p>For the last decade, Travel & Go have organized many international itineraries.</p>
        </div>
      </div>
      <div className='welcomeContent'>
        <h3>Welcome</h3>
        <p>Welcome to Travel & Go, your ultimate destination for adventure and exploration! At Travel & Go, we believe in the transformative power of travel, and our mission is to inspire and guide you on your journey to discovering the world's wonders. Whether you're a seasoned globetrotter or a first-time explorer, our platform is designed to provide you with valuable insights, expert tips, and curated recommendations to make your travel experiences unforgettable. Join us as we embark on a virtual voyage, offering a treasure trove of information on breathtaking destinations, cultural discoveries, and travel essentials. Let Travel & Go be your compass to exciting destinations and extraordinary memories. Start your adventure with us and let the journey begin!</p>
      </div>
      <div className='banner'>
        <div className='bannerContents'>
        <h3>Dream, Explore, Discover</h3>
        <p>Let Your journey be the masterpiece of a lifetime.</p>
        </div>
      </div>

      <div className='gallery'>
      <h3>Gallery</h3>
      </div>
      <div className="wrapper">
        <div className="box a"></div>
        <div className="box b"></div>
        <div className="box c"></div>
        <div className="box d"></div>
        <div className="box e"></div>
        </div>
        <FooterContent/>
    </div>


  )
}

export default Home;